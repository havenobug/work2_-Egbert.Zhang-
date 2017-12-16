package com.service.serviceimpl;

import com.dao.MessageMapper;
import com.entity.Message;
import com.service.MessaeService;
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
    public void myedit(Integer id, String title, String artical) {
        messageMapper.myedit(id,title,artical);
    }


    @Override
    public void addmy(String title, String artical, String username, Date reporttime,Date lasttime) {
        messageMapper.addmy(title,artical,username,reporttime,lasttime);
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
