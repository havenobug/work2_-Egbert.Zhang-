package com.service;

import com.dao.MessageMapper;
import com.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("messageService")
public class MessageServiceImpl implements MessaeService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> findAll() {
        return messageMapper.findAll();
    }

    public List<Message> findMy(String username){
        return messageMapper.findMy(username);
    }

    @Override
    public void myedit(int id) {
        messageMapper.myedit(id);
    }

    @Override
    public void addmy(String title, String artical, String username, Date reporttime) {
        messageMapper.addmy(title,artical,username,reporttime);
    }

    @Override
    public void deletemes(int id) {
        messageMapper.deletemes(id);
    }

    @Override
    public Message findMessById(int id) {
        return messageMapper.findMessById(id);
    }

}
