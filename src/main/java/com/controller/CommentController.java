package com.controller;

import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    CommentService commentService;
    //发表评论
    @RequestMapping("putCom")
    public String putCom(String comment, Integer id, String username,HttpServletRequest request){
        username = (String)request.getSession().getAttribute("username");
        id = (Integer)request.getSession().getAttribute("id");
        commentService.putCom(comment,id,username);
        commentService.commentnumAdd(id);
        return "redirect:/message";
    }
}
