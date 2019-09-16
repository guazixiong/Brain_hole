package com.example.zut.pd.service;

import com.example.zut.pd.dao.domain.UserDomain;

import java.util.ArrayList;

/*
*  int uid;   //序号 自动递增
    String uname; //网名
    String uphone;  //电话号
    String uemail;  //邮箱
    String upassword; //密码
    String ufavor;  //用户喜好
    double umoney;  //钱包
    String ustar;   //收藏夹
* */
public interface UserService {

    //注册
    String register(String uname, String uphone, String uemail, String upassword,
                    String ufavor);

    //登录
    String Login(String phone_or_email, String upassword);

    //返回用户个人信息
    UserDomain showUser(String uid);

    //更新个人信息
        /*
    * 通过登录之后获取到的账号(手机号/邮箱)
    * 允许更改
    * 网名uname,手机号uphone,邮箱uemail,密码upassword,喜好ufavor
    *
    * */
    UserDomain updateUser(String uid, String uname, String uphone,
                          String uemail, String upassword, String ufavor);

}
