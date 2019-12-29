package com.example.zut.pd.service.ServiceImpl;

import com.example.zut.pd.ToolsUtil.ToolsUtil;
import com.example.zut.pd.dao.Userdao;
import com.example.zut.pd.dao.domain.ReturnDomain;
import com.example.zut.pd.dao.domain.UserDomain;
import com.example.zut.pd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    //依赖注入
    @Autowired
    Userdao userdao;
    @Autowired
    ReturnDomain returnDomain;
    @Autowired
    ToolsUtil toolsUtil;

    //用户注册
    @Override
    public String register(String uName, String uPhone, String uEmail,
                           String uPassword, String uFavor, String uProblem1, String uQuestion1, String uProblem2,
                           String uQuestion2) {
        /*
        * 网名不为空,电话号要求11位,密码长度要求大于6位
        * 手机号和邮箱可以为空,但是不能两个都为空
        * 个人喜好不为空
        * */
        if (uName == null || toolsUtil.flag(uPhone, uEmail) == false
                || uPassword.length() < 6 || uFavor == null || uQuestion1 == null || uQuestion2 == null
                ) {
            //输入格式存在问题
            return returnDomain.getR0();
        } else {
            //若用户已存在
            if (userdao.FindUserPhone(uPhone, uPassword) != null
                    || userdao.FindUserEmail(uEmail, uPassword) != null) {
                return returnDomain.getR4();
            }
            //若用户不存在
            else {
                UserDomain userDomain = new UserDomain();
                userDomain.setuName(uName);
                if (!uPhone.equals("0")) {
                    userDomain.setuPhone(uPhone);
                }
                if (!uEmail.equals("0")) {
                    userDomain.setuEmail(uEmail);
                }
                userDomain.setuPassword(uPassword);
                userDomain.setuFavor(uFavor);
                userDomain.setuProblem1(uProblem1);
                userDomain.setuQuestion1(uQuestion1);
                userDomain.setuProblem2(uProblem1);
                userDomain.setuQuestion2(uQuestion2);
                userdao.register(userDomain);
                //获取uId值,传参到前端并保存在session对象中
                String a = " ";
                if (userdao.FindUserEmail(uEmail, uPassword) != null)
                    a = String.valueOf(userdao.FindUserEmail(uEmail, uPassword).getuId());
                else if (userdao.FindUserPhone(uPhone, uPassword) != null)
                    a = String.valueOf(userdao.FindUserPhone(uPhone, uPassword).getuId());
                else
                    a = "出现未知错误";
                return a;
            }
        }
    }

    //登录(通过手机号或者邮箱进行登录)
    @Override
    public String LoginPhoneEmail(String phone_or_email, String uPassword) {
        //判断是手机号还是邮箱
        //手机号符合规则还必须不为空
        if (toolsUtil.DetectPhone(phone_or_email).equals(returnDomain.getR1())) {
            //找到用户,返回用户的uId值
            if (userdao.FindUserPhone(phone_or_email, uPassword) != null)
                return String.valueOf(userdao.FindUserPhone(phone_or_email, uPassword).getuId());
                //未找到用户
            else
                return returnDomain.getR5();
        }
        //邮箱符合规则且不为空
        else if (toolsUtil.DetectEmail(phone_or_email).equals(returnDomain.getR1())) {
            //找到用户,返回用户的uId值
            if (userdao.FindUserEmail(phone_or_email, uPassword) != null)
                return String.valueOf(userdao.FindUserEmail(phone_or_email, uPassword).getuId());
                //未查找到用户
            else
                return returnDomain.getR5();
        }
        //账号匹配失败,返回输入问题
        else
            return returnDomain.getR5();
    }

    //登录(通过序列号进行登录)
    @Override
    public int LoginId(int Id, String uPassword) {
        /*
        * 返回属于用户的身份验证,普通用户为1,管理员为2
        * 用户的id直接由前端进行存储
        * */
        //判断用户是否存在
        return userdao.FindUser(Id) != null ? 1 : 2;

    }

    //根据序号返回个人信息
    @Override
    public UserDomain showUser(int uId) {
        return userdao.FindUser(uId);
    }

    //修改个人信息
    @Override
    public UserDomain updateUser(int uId, String uName, String uFavor) {
        /*
        * 网名识别非法关键词,后续添加
        * */
        if (uName == null || uFavor == null
                ) {
            //输入格式存在问题
            return null;
        } else {
            //格式正确,更新个人信息
            UserDomain userDomain = userdao.FindUser(uId);
            userDomain.setuName(uName);
            userDomain.setuFavor(uFavor);
            return userdao.updateUser(userDomain);
        }
    }

    //验证密保
    @Override
    public String VerifyEncrypted(int uId, String Problem, String Question) {
        //uId和Problem事先预设,只有Question需要用户进行填写
        if (Question.equals(" "))
            return returnDomain.getR0();
        else {
            //找用户
            UserDomain user = userdao.FindUser(uId);
            //判别是哪一个用户
            if (user.getuProblem1().equals(Problem) && user.getuQuestion1().equals(Question))
                return returnDomain.getR1();
            else if (user.getuProblem2().equals(Problem) && user.getuQuestion2().equals(Question))
                return returnDomain.getR1();
            else
                return returnDomain.getR2();
        }
    }

    //修改密码
    @Override
    public String updateUserPassword(int uId, String LaterPassword, String TodayPassword) {
        //对密码长度进行辨别
        if (LaterPassword.length() < 6 || TodayPassword.length() < 6)
            return returnDomain.getR0();
        else {
            //找到用户,更改密码
            UserDomain user = userdao.FindUser(uId);
            //密码一致,执行成功
            if (LaterPassword.equals(user.getuPassword())) {
                //修改密码
                user.setuPassword(TodayPassword);
                userdao.updateUserAll(user);
                return returnDomain.getR1();
            }
            //密码不一致,执行失败
            else
                return returnDomain.getR0();
        }
    }

    //修改密保问题
    @Override
    public String updateUserEncrypted(int uId, String todayProblem1, String todayQuestion1, String todayProblem2, String todayQuestion2) {
        //uId和问题都是确定的,只需要控制回答
        if (todayQuestion1.equals(" ") || todayQuestion2.equals(" "))
            return returnDomain.getR0();
        else {
            UserDomain user = userdao.FindUser(uId);
            if (user != null) {
                user.setuProblem1(todayProblem1);
                user.setuQuestion1(todayQuestion1);
                user.setuProblem2(todayProblem2);
                user.setuQuestion2(todayQuestion2);
                userdao.updateUserAll(user);
                return returnDomain.getR1();
            } else
                return returnDomain.getR8();
        }
    }
}
