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
    UserDomain FindUserPhone(@Param("uphone") String uphone, @Param("upassword") String upassword);

    //通过邮箱+密码来查找用户
    UserDomain FindUserEmail(@Param("uemail") String uemail, @Param("upassword") String upassword);

    //通过手机号来查找用户
    UserDomain FindOnlyUserPhone(String uphone);

    //通过邮箱来查找用户
    UserDomain FindOnlyUserEmail(String uemail);

}
