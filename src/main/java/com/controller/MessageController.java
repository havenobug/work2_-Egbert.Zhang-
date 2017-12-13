package com.controller;

import com.entity.Comment;
import com.entity.Message;
import com.service.CommentService;
import com.service.MessaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class MessageController {
    @Autowired
    MessaeService messageService;
    @Autowired
    CommentService commentService;


    @RequestMapping({"/addmymessage"})
    public String addmy() {
        return "addmymessage";
    }

    @RequestMapping({"/editmymessage"})
    public String addmyedit() {
        return "editmymessage";
    }


    //显示所有消息
    @RequestMapping({"/message"})
    public String showmessage(Model model){
        List<Message> messages = messageService.findAll();
        model.addAttribute("messages",messages);
        return "message";
    }

    //显示我自己的消息
    @RequestMapping({"/mymessage"})
    public String showmymessage(HttpServletRequest request,String username,Model model){
//        List<Message> messages = messageService.
        username =(String)request.getSession().getAttribute("username");
        List<Message> messages = messageService.findMy(username);
        model.addAttribute("messages",messages);
        return "mymessage";
    }

    //查看消息的详情页面
    @RequestMapping({"/showmessage"})
    public String showmes(Model model,Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id",id);
        Message messages = messageService.findMessById(id);
        model.addAttribute("messages" ,messages);
        List<Comment> comment =commentService.findCom(id);
        model.addAttribute("comment",comment);
        return "showmessage";

    }


    //删除消息
    @RequestMapping("/delete")
    public String delete(int id) {
        messageService.deletemes(id);
        return "redirect:/message";
    }

    //删除我自己的信息
    @RequestMapping("/deletemymessage")
    public String deletemymessage(int id){
        messageService.deletemes(id);
        return "redirect:/mymessage";
    }

    //修改我自己的信息
    @RequestMapping("/addmyedit")
    public String registerUser(int id){
        Date date = new Date();
        messageService.myedit(id);
        return "redirect:/editmymessage";
    }

    //添加我自己的信息
    @RequestMapping("/addmessage")
    public String addmy(String title,String artical,String username,HttpServletRequest request){
        Date date = new Date();
        username = (String)request.getSession().getAttribute("username");
        messageService.addmy(title,artical,username,date);
        return "addmymessage";
    }


}
