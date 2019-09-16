package com.example.zut.pd.web;

import com.example.zut.pd.dao.domain.UserDomain;
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
    String Login(@RequestParam("phone_or_email") String phone_or_email,
                 @RequestParam("upassword") String upassword) {
        return userService.Login(phone_or_email, upassword);
    }

    //返回个人信息
    //根据登录界面返回的账号uid
    @RequestMapping(value = "showUser")
    UserDomain showUser(@RequestParam("uid") String uid){
        return userService.showUser(uid);
    }

    //更新个人信息
    /*
    * 通过登录之后获取到的账号(手机号/邮箱)
    * 允许更改
    * 网名uname,手机号uphone,邮箱uemail,密码upassword,喜好ufavor
    *
    * */
    @RequestMapping(value = "updateUser")
    UserDomain updateUser(@RequestParam("uid")String uid,@RequestParam("uname")String uname,
                          @RequestParam("uphone")String uphone,@RequestParam("uemail")String uemail,
                          @RequestParam("upassword")String upassword,
                          @RequestParam("ufavor")String ufavor){
        return userService.updateUser(uid,uname,uphone,uemail,upassword,ufavor);
    }
}
