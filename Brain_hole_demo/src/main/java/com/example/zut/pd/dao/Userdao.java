package com.example.zut.pd.dao;

import com.example.zut.pd.dao.domain.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Userdao {
    //用户注册
    void register(UserDomain userDomain);

}
