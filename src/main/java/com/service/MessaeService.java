package com.service;

import com.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessaeService {
    List<Message> findAll();

    List<Message> findMy(String username);

    void myedit(Integer id,String title,String artical);

    void addmy(String title, String artical, String username, Date reporttime,Date lastdate);

    void deletemes(int id);

    Message findMessById(int id);
}
