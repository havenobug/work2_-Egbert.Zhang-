package com.service;

import com.entity.Message;

import java.util.Date;
import java.util.List;

public interface MessaeService {
    List<Message> findAll();

    List<Message> findMy(String username);

    void myedit(int id);

    void addmy(String title, String artical, String username, Date reporttime);

    void deletemes(int id);

    Message findMessById(int id);
}
