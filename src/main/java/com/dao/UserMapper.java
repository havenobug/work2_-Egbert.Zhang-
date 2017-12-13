package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findById(Integer id);
    User findByUsername(String usernmae);
    User findByPassword(String password);
    void register(@Param("username") String username, @Param("password") String password);

}
