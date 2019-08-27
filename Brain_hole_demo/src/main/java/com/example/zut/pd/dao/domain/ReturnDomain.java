package com.example.zut.pd.dao.domain;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnDomain {

    private String r0 = "输入出现问题,请重新输入";
    private String r1 = "执行成功";

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
}