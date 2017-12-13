package com.service;

import com.dao.CommentMapper;
import com.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> findCom(int id) {
        return commentMapper.findCom(id);
    }

    @Override
    public void putCom(String comment, Integer cid, String username) {
        Comment com = new Comment();
        com.setComment(comment);
        com.setCid(cid);
        com.setUsername(username);
        commentMapper.putCom(com);
    }


}
