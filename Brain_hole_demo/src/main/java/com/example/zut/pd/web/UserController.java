package com.example.zut.pd.web;

import com.example.zut.pd.dao.domain.ReturnDomain;
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
    @Autowired
    ReturnDomain returnDomain;

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
    int LoginId(@RequestParam("Id") int Id,
                @RequestParam("uPassword") String uPassword) {
        return userService.LoginId(Id, uPassword);
    }

    //返回个人信息
    //根据登录界面返回的账号uId
    @RequestMapping(value = "showUser")
    UserDomain showUser(@RequestParam("uId") int uId) {
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
    UserDomain updateUser(@RequestParam("uId") int uId, @RequestParam("uName") String uName,
                          @RequestParam("uFavor") String uFavor) {
        return userService.updateUser(uId, uName, uFavor);
    }

    /*
    * 验证密保1
    * 返回执行成功或失败
    * */
    @RequestMapping(value = "VerifyEncrypted1")
    String VerifyEncrypted1(@RequestParam("uId") int uId,
                            @RequestParam("Problem") String Problem,
                            @RequestParam("Question") String Question) {
        return userService.VerifyEncrypted(uId, Problem, Question);
    }

    /*
    * 验证密保2
    * */
    @RequestMapping(value = "VerifyEncrypted2")
    String VerifyEncrypted2(@RequestParam("uId") int uId,
                            @RequestParam("LaterProblem1") String LaterProblem1,
                            @RequestParam("LaterQuestion1") String LaterQuestion1,
                            @RequestParam("LaterProblem2") String LaterProblem2,
                            @RequestParam("LaterQuestion2") String LaterQuestion2) {
        //利用单一密保验证原则,同时成立的时候返回变量
        if (userService.VerifyEncrypted(uId, LaterProblem1, LaterQuestion1).equals(returnDomain.getR1())
                && userService.VerifyEncrypted(uId, LaterProblem2, LaterQuestion2).equals(returnDomain.getR1())
                )
            return returnDomain.getR1();
        else
            return returnDomain.getR0();
    }


    /*
    * 修改密码
    * 返回执行成功或失败
    * */
    @RequestMapping(value = "updateUserPassword")
    String updateUserPassword(@RequestParam("uId") int uId,
                              @RequestParam("LaterPassword") String LaterPassword,
                              @RequestParam("TodayPassword") String TodayPassword) {
        return userService.updateUserPassword(uId, LaterPassword, TodayPassword);
    }

    /*
    * 修改密保问题
    * 返回执行成功或失败
    * */
    @RequestMapping(value = "updateUserEncrypted")
    String updateUserEncrypted(@RequestParam("uId") int uId,
                               @RequestParam("TodayProblem1") String TodayProblem1,
                               @RequestParam("TodayQuestion1") String TodayQuestion1,
                               @RequestParam("TodayProblem2") String TodayProblem2,
                               @RequestParam("TodayQuestion2") String TodayQuestion2) {
        return userService.updateUserEncrypted(uId,TodayProblem1,TodayQuestion1,TodayProblem2,TodayQuestion2);
    }
}
