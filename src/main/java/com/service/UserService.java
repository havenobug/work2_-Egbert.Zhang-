package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    //查找用户名
    User findUserByUsername(String username);
    //通过用户名查找密码
    User findUserByPassword(String username);
    //注册
    void register(String username, String password);
    //显示所有用户
    List<User> findAllUser();
    //查找用户的权限
    User findRole(String username);
    //编辑用户的权限
    void editRole(Integer id, Integer role);
}
