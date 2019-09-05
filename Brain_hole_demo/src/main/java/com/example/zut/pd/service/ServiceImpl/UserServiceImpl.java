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

    @Autowired
    Userdao userdao;
    @Autowired
    ReturnDomain returnDomain;
    @Autowired
    ToolsUtil toolsUtil;

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
            if (userdao.FindOnlyUserPhone(uphone) != null
                    || userdao.FindOnlyUserEmail(uemail) != null) {
                return returnDomain.getR4();
            }
            //若用户未存在
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
                return returnDomain.getR1();
            }
        }
    }

    //登录
    @Override
    public String Login(String uid, String upassword) {
        //判断是手机号还是邮箱
        //手机号符合规则还必须不为空
        if (toolsUtil.DetectPhone(uid).equals(returnDomain.getR1())) {
            if (userdao.FindUserPhone(uid, upassword) != null)
                return returnDomain.getR1();
            else
                return returnDomain.getR5();
        }
        //邮箱符合规则且不为空
        else if (toolsUtil.DetectEmail(uid).equals(returnDomain.getR1())) {
            //查找到用户
            if (userdao.FindUserEmail(uid, upassword) != null)
                return returnDomain.getR1();
                //未查找到用户
            else
                return returnDomain.getR5();
        }
        //账号匹配失败,返回输入问题
        else
            return returnDomain.getR0();
    }


}
