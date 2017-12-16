package com.service;

import com.entity.Comment;

import java.util.List;

public interface CommentService {
    //显示评论
    List<Comment> findCom(int id);

    //添加评论
    void putCom(String comment, Integer cid, String username);

    //评论数加一
    void commentnumAdd(int id);
}
