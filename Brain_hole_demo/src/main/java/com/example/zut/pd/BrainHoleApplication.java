package com.example.zut.pd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.zut.pd")
/*
*扫包
* 若出现扫包失败的情况
*     1.新建包将所有类包含在内,重新定义@ComponentScan的扫包路径
*     2.可以在扫包失败的类中添加@Componet注解
*
 */
@SpringBootApplication
public class BrainHoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrainHoleApplication.class, args);
    }

}
