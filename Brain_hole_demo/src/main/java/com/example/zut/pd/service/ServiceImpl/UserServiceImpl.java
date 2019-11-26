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

    /*
    *     private String r0 = "输入出现问题,请重新操作";
    private String r1 = "执行成功";
    private String r2 = "执行失败";
    private String r3 = "参数为空";
    private String r4 = "用户已存在";
    private String r5 = "用户不存在,请检查你的账号和密码";
    * */

    //注册
    @Override
    public String register(String uname, String uphone, String uemail,
                           String upassword, String ufavor) {
        /*
        * 网名不为空,电话号要求11位,密码长度要求大于6位
        * 手机号和邮箱可以为空,但是不能两个都为空
        * 个人喜好不为空
        * */
        if (uname == null || toolsUtil.flag(uphone, uemail) == false
                || upassword.length() < 6 || ufavor == null
                ) {
            //输入格式存在问题
            return returnDomain.getR0();
        } else {
            //若用户已存在
            if (userdao.FindUserPhone(uphone, upassword) != null
                    || userdao.FindUserEmail(uemail, upassword) != null) {
                return returnDomain.getR4();
            }
            //若用户不存在
            else {
                UserDomain userDomain = new UserDomain();
                userDomain.setUname(uname);
                if (!uphone.equals("0"))
                    userDomain.setUphone(uphone);
                if (!uemail.equals("0"))
                    userDomain.setUemail(uemail);
                userDomain.setUpassword(upassword);
                userDomain.setUfavor(ufavor);
                userdao.register(userDomain);
                //获取uid值,传参到前端并保存在session对象中
                return String.valueOf(userDomain.getUid());
            }
        }
    }

    //登录
    @Override
    public String Login(String phone_or_email, String upassword) {
        //判断是手机号还是邮箱
        //手机号符合规则还必须不为空
        if (toolsUtil.DetectPhone(phone_or_email).equals(returnDomain.getR1())) {
            //找到用户,返回用户的uid值
            if (userdao.FindUserPhone(phone_or_email, upassword) != null)
                return String.valueOf(userdao.FindUserPhone(phone_or_email, upassword).getUid());
                //未找到用户
            else
                return returnDomain.getR5();
        }
        //邮箱符合规则且不为空
        else if (toolsUtil.DetectEmail(phone_or_email).equals(returnDomain.getR1())) {
            //找到用户,返回用户的uid值
            if (userdao.FindUserEmail(phone_or_email, upassword) != null)
                return String.valueOf(userdao.FindUserEmail(phone_or_email, upassword).getUid());
                //未查找到用户
            else
                return returnDomain.getR5();
        }
        //账号匹配失败,返回输入问题
        else
            return returnDomain.getR5();
    }

    //根据序号返回个人信息
    @Override
    public UserDomain showUser(String uid) {
        return userdao.FindUser(uid);
    }

    //更新个人信息
        /*
    * 通过登录之后获取到的账号(手机号/邮箱)
    * 允许更改
    * 网名uname,手机号uphone,邮箱uemail,密码upassword,喜好ufavor
    *
    * */
    @Override
    public UserDomain updateUser(String uid, String uname, String uphone,
                                 String uemail, String upassword, String ufavor) {
        if (uname == null || toolsUtil.flag(uphone, uemail) == false
                || upassword.length() < 6 || ufavor == null
                ) {
            //输入格式存在问题
            return null;
        } else {
            //格式正确,更新个人信息
            UserDomain userDomain = userdao.FindUser(uid);
            userDomain.setUname(uname);
            userDomain.setUphone(uphone);
            userDomain.setUemail(uemail);
            userDomain.setUpassword(upassword);
            userDomain.setUfavor(ufavor);
            return userdao.updateUser(userDomain);
        }
    }
}
