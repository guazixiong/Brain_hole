package com.example.zut.pd.dao;

import com.example.zut.pd.dao.domain.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Userdao {
    //用户注册
    void register(UserDomain userDomain);

    //通过手机号+密码来查找用户
    UserDomain FindUserPhone(@Param("uPhone") String uPhone, @Param("uPassword") String uPassword);

    //通过邮箱+密码来查找用户
    UserDomain FindUserEmail(@Param("uEmail") String uEmail, @Param("uPassword") String uPassword);

    //通过序号来查找用户
    UserDomain FindUser(int uId);

    //更新用户个人信息,返回用户对象信息
    UserDomain updateUser(UserDomain userDomain);

    //更新信息,只更新,不反悔对象信息
    void updateUserAll(UserDomain userDomain);
}
