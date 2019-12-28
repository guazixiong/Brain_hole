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
    * 网名,手机号,邮箱,密码,喜好,问题1,答案1,问题2,答案2
    * */
    @RequestMapping(value = "register")
    String register(@RequestParam("uName") String uName, @RequestParam("uPhone") String uPhone,
                    @RequestParam("uEmail") String uEmail, @RequestParam("uPassword") String uPassword,
                    @RequestParam("uFavor") String uFavor, @RequestParam("uProblem1") String uProblem1,
                    @RequestParam("uQuestion1") String uQuestion1, @RequestParam("uProblem2") String uProblem2,
                    @RequestParam("uQuestion2") String uQuestion2) {
        return userService.register(uName, uPhone, uEmail, uPassword, uFavor, uProblem1, uQuestion1, uProblem2, uQuestion2);
    }

    //登录
    /*
    * 手机号或邮箱  +   密码登录
    * 返回用户的序列号
    * */
    @RequestMapping(value = "Login")
    String LoginPhoneEmail(@RequestParam("phone_or_email") String phone_or_email,
                           @RequestParam("uPassword") String uPassword) {
        return userService.LoginPhoneEmail(phone_or_email, uPassword);
    }

    //登录
    /*
    * 序列号+密码登录
    * 返回用户的序列号
    * */
    int LoginId(@RequestParam("Id") String Id,
                @RequestParam("uPassword") String uPassword) {
        return userService.LoginId(Id, uPassword);
    }

    //返回个人信息
    //根据登录界面返回的账号uId
    @RequestMapping(value = "showUser")
    UserDomain showUser(@RequestParam("uId") String uId) {
        return userService.showUser(uId);
    }

    //更新个人信息
    /*
    * 通过登录之后获取到的账号(手机号/邮箱)
    * 允许更改
    * 网名uName,手机号uPhone,邮箱uEmail,密码uPassword,喜好uFavor
    *
    * */
    @RequestMapping(value = "updateUser")
    UserDomain updateUser(@RequestParam("uId") String uId, @RequestParam("uName") String uName,
                          @RequestParam("uPhone") String uPhone, @RequestParam("uEmail") String uEmail,
                          @RequestParam("uPassword") String uPassword,
                          @RequestParam("uFavor") String uFavor) {
        return userService.updateUser(uId, uName, uPhone, uEmail, uPassword, uFavor);
    }
}
