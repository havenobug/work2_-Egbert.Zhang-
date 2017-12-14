package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    User findUserByPassword(String username);
    void register(String username, String password);
    List<User> findAllUser();
    User findRole(String username);
    void editRole(Integer id,Integer role);
}
