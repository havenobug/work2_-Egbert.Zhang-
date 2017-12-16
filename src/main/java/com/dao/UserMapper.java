package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findById(Integer id);
    User findByUsername(String usernmae);
    User findByPassword(String password);
    void register(@Param("username") String username, @Param("password") String password);
    List<User> findAllUser();
    User findByRole(@Param("username") String username);

    void editRole(@Param("id") Integer id, @Param("role") Integer role);
}
