package com.example.zut.pd.service;

import com.example.zut.pd.dao.domain.UserDomain;

import java.util.ArrayList;

/*
*  int uId;   //序号 自动递增
    String uName; //网名
    String uPhone;  //电话号
    String uEmail;  //邮箱
    String uPassword; //密码
    String uFavor;  //用户喜好
    double umoney;  //钱包
    String ustar;   //收藏夹
* */
public interface UserService {

    //注册
    String register(String uName, String uPhone, String uEmail, String uPassword,
                    String uFavor, String uProblem1, String uQuestion1, String uProblem2,
                    String uQuestion2);

    //登录(通过手机号或邮箱+密码进行登录)
    String LoginPhoneEmail(String phone_or_email, String uPassword);

    //登录(通过序列号进行登录)
    int LoginId(String Id, String uPassword);

    //返回用户个人信息
    UserDomain showUser(String uId);

    //更新个人信息
        /*
    * 通过登录之后获取到的账号(手机号/邮箱)
    * 允许更改
    * 网名uName,手机号uPhone,邮箱uEmail,密码uPassword,喜好uFavor
    *
    * */
    UserDomain updateUser(String uId, String uName, String uPhone,
                          String uEmail, String uPassword, String uFavor);

}
