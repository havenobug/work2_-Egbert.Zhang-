package com.dao;
import com.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {
        //显示所有用户的message
        List<Message> findAll();
        //显示当前用户的message
        List<Message> findMy(@Param("username") String username);

        //修改自己的信息
        void myedit(@Param("id")Integer id,@Param("title")String title,@Param("artical")String artical);

        //新增自己的文章
        void addmy(@Param("title") String title, @Param("artical") String artical, @Param("username") String username, @Param("reporttime") Date repottime,@Param("lastdate")Date lastdate);

        //删除自己的文章
        void deletemes(@Param("id") Integer id);

        //显示当前的文章
        Message findMessById(@Param("id") int id);
}
