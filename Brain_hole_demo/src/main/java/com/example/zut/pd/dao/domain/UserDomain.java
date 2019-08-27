package com.example.zut.pd.dao.domain;

public class UserDomain {
    private int uid;   //序号 自动递增
    private String uname; //网名
    private String uphone=null;  //电话号
    private String uemail=null;  //邮箱
    private String upassword; //密码
    private String ufavor=null;  //用户喜好
    private double umoney=0;  //钱包
    private String ustar=null;   //收藏夹

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUfavor() {
        return ufavor;
    }

    public void setUfavor(String ufavor) {
        this.ufavor = ufavor;
    }

    public double getUmoney() {
        return umoney;
    }

    public void setUmoney(double umoney) {
        this.umoney = umoney;
    }

    public String getUstar() {
        return ustar;
    }

    public void setUstar(String ustar) {
        this.ustar = ustar;
    }
}
