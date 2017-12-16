package com.service.serviceimpl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findRole(String username) {
        return userMapper.findByRole(username);
    }

    @Override
    public void editRole(Integer id, Integer role) {
        userMapper.editRole(id,role);
    }
}
