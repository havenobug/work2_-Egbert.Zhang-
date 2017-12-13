package com.service;

import com.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findCom(int id);

    void putCom(String comment,Integer cid,String username);
}
