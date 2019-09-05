package com.example.zut.pd.service;

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
    String Login(String uid,String upassword);
}
