package com.service;

import com.entity.User;

public interface UserService {
    User findUserByUsername(String username);
    User findUserByPassword(String username);
    void register(String username, String password);
}
