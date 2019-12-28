package com.example.zut.pd.dao.domain;

public class UserDomain {
    /*
    * 编号,网名,电话号,邮箱,密码,用户喜好,钱包.收藏夹,密保问题1,回答1,密保问题2,回答2
    * */
    private int uId;   //序号 自动递增
    private String uName; //网名
    private String uPhone = null;  //电话号
    private String uEmail = null;  //邮箱
    private String uPassword; //密码
    private String uFavor = null;  //用户喜好
    private double uMoney = 0;  //钱包
    private String uStar = null;   //收藏夹
    private String uProblem1;  //密保问题1
    private String uQuestion1; //回答1
    private String uProblem2;  //密保问题2
    private String uQuestion2; //回答2


    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuFavor() {
        return uFavor;
    }

    public void setuFavor(String uFavor) {
        this.uFavor = uFavor;
    }

    public double getuMoney() {
        return uMoney;
    }

    public void setuMoney(double uMoney) {
        this.uMoney = uMoney;
    }

    public String getuStar() {
        return uStar;
    }

    public void setuStar(String uStar) {
        this.uStar = uStar;
    }

    public String getuProblem1() {
        return uProblem1;
    }

    public void setuProblem1(String uProblem1) {
        this.uProblem1 = uProblem1;
    }

    public String getuQuestion1() {
        return uQuestion1;
    }

    public void setuQuestion1(String uQuestion1) {
        this.uQuestion1 = uQuestion1;
    }

    public String getuProblem2() {
        return uProblem2;
    }

    public void setuProblem2(String uProblem2) {
        this.uProblem2 = uProblem2;
    }

    public String getuQuestion2() {
        return uQuestion2;
    }

    public void setuQuestion2(String uQuestion2) {
        this.uQuestion2 = uQuestion2;
    }
}
