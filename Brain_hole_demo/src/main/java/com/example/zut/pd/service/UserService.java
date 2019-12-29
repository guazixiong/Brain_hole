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
    int LoginId(int Id, String uPassword);

    //返回用户个人信息
    UserDomain showUser(int uId);

    /*
    * 更新个人信息
    * 网名uName,喜好uFavor
    * */
    UserDomain updateUser(int uId, String uName, String uFavor);

    /*
    * 修改手机号
    * 要求:填写手机号,发送验证码,识别验证码,完成验证
    * */

    /*
    * 修改绑定邮箱
    * 要求:填写邮箱,发送验证码,识别验证码,完成验证
    * */

    /*
    *验证密保
    * 返回执行成功或失败
    * */
    String VerifyEncrypted(int uId, String Problem, String Question);

    /*
   * 修改密码
   * 返回执行成功与失败
   * */
    String updateUserPassword(int uId, String LaterPassword, String TodayPassword);

    /*
    * 修改密保问题
    * 返回执行成功或失败
    * */
    String updateUserEncrypted(int uId, String todayProblem1, String todayQuestion1, String todayProblem2, String todayQuestion2);
}
