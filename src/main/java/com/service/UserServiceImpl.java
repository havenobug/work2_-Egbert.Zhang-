package com.service;

import com.dao.UserMapper;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findUserByPassword(String password) {
        return userMapper.findByPassword(password);
    }

    @Override
    public void register(String username, String password) {
        userMapper.register(username,password);
    }
}
