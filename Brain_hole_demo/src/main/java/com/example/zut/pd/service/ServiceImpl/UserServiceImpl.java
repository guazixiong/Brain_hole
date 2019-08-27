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

    @Override
    public String register(String uname, String uphone, String uemail,
                           String upassword, String ufavor) {
        /*
        * 网名要求6字节,电话号要求11位,密码要求10位之内
        * 手机号和邮箱可以为空,但是不能两个都为空
        *
        * */
        if (uname.length() > 6 || toolsUtil.flag(uphone, uemail) == false
                || upassword.length() > 10 || ufavor == null
                ) {
            return returnDomain.getR0();
        } else {
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
