package com.dao;

import com.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    //显示评论
    List<Comment> findCom(@Param("id")int id);
    //发表评论
    void putCom(@Param("com")Comment com);
//    void putCom(@Param("Comment")String comment,@Param("id")int id,@Param("username")String username);

}
