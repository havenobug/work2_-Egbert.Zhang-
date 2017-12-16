package com.service;

import com.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessaeService {
    //显示所有信息
    List<Message> findAll();

    //显示我自己的信息
    List<Message> findMy(String username);

    //编辑我自己的信息
    void myedit(Integer id, String title, String artical);

    //添加我的信息
    void addmy(String title, String artical, String username, Date reporttime, Date lastdate);

    //删除我的信息
    void deletemes(int id);

    //通过id查找消息
    Message findMessById(int id);
}
