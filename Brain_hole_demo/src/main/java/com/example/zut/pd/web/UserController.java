package com.example.zut.pd.web;

import com.example.zut.pd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //注册
    /*
    * 网名,手机号,邮箱,密码,喜好
    * */
    @RequestMapping(value = "register")
    String register(@RequestParam("uname") String uname, @RequestParam("uphone") String uphone,
                    @RequestParam("uemail") String uemail, @RequestParam("upassword") String upassword,
                    @RequestParam("ufavor") String ufavor) {
        return userService.register(uname, uphone, uemail, upassword, ufavor);
    }

    //登录
    /*
    * 手机号或邮箱  +   密码登录
    * */
    @RequestMapping(value = "Login")
    String Login(@RequestParam("uid") String uid,
                 @RequestParam("upassword") String upassword) {
        return userService.Login(uid, upassword);
    }
}
