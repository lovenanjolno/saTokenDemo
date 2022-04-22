package com.pj.mapper;

import com.pj.pojo.UserData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserData findAll();

    UserData findUserNameAndPassword(String username, String password);
}
