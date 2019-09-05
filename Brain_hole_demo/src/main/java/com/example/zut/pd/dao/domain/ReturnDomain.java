package com.example.zut.pd.dao.domain;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnDomain {

    private String r0 = "输入出现问题,请重新操作";
    private String r1 = "执行成功";
    private String r2 = "执行失败";
    private String r3 = "参数为空";
    private String r4 = "用户已存在";
    private String r5 = "用户不存在,请检查你的账号和密码";

    public String getR0() {
        return r0;
    }

    public void setR0(String r0) {
        this.r0 = r0;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String getR5() {
        return r5;
    }

    public void setR5(String r5) {
        this.r5 = r5;
    }
}