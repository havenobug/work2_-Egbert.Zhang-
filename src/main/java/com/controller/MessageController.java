package com.controller;

import com.entity.Comment;
import com.entity.Message;
import com.entity.User;
import com.service.CommentService;
import com.service.MessaeService;
import com.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class MessageController {
    @Autowired
    MessaeService messageService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;


    @RequestMapping({"/addmymessage"})
    public String addmy() {
        return "addmymessage";
    }

    @RequestMapping({"/editmymessage"})
    public String addmyedit() {
        return "editmymessage";
    }


    //管理员的界面
    @RequestMapping({"/adminmessage"})
    public String showadmin(Model model){
        List<Message> messages = messageService.findAll();
        model.addAttribute("messages",messages);
        List<User> users = userService.findAllUser();
        model.addAttribute("users",users);
        return "adminmessage";
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


    //删除消息 并且判断当前用户的角色 0 代表没什么权限，1代表可以删除别人的文章
    @RequestMapping("/delete")
    public String delete(int id, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        User user = userService.findRole(username);
        int role = user.getRole();

        if (role==0||role==2){
            out.print("<script language=\"javascript\">alert('对不起你没有这个权限')</script>");
        }
        else if(role==1||role==3){
            messageService.deletemes(id);
            return "redirect:/message";
        }
        return "redirect:/message";

    }
    //管理员删除信息
    @RequestMapping("/admindelete")
    public String admindelete(int id){
        messageService.deletemes(id);
        return "redirect:/adminmessage";
    }

    //删除我自己的信息
    @RequestMapping("/deletemymessage")
    public String deletemymessage(int id){

        messageService.deletemes(id);
        return "redirect:/mymessage";
    }

    //修改我自己的信息
    @RequestMapping("/toEdit")
    public String toEdit(Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id1",id);
        return "editmymessage";

    }
    @RequestMapping("/addmyedit")
    public String edit(Integer id,String title,String artical,HttpServletRequest request){
        id = (Integer) request.getSession().getAttribute("id1");
        System.out.println(title+artical+"meiyou"+id);
        messageService.myedit(id,title,artical);
        return "redirect:/mymessage";
    }

    //添加我自己的信息
    @RequestMapping("/addmessage")
    public String addmy(String title,String artical,String username,HttpServletRequest request){
        Date date = new Date();
        username = (String)request.getSession().getAttribute("username");
        messageService.addmy(title,artical,username,date,date);
        return "addmymessage";
    }
    //管理员修改信息
    @RequestMapping("/admintoedit")
    public String admintoedit(Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id2",id);
        return "adminedit";
    }
    @RequestMapping("/adminedit")
    public String adminedit(Integer id,String title,String artical,HttpServletRequest request){
        id= (Integer) request.getSession().getAttribute("id2");
        messageService.myedit(id,title,artical);
        return "redirect:/adminmessage";
    }

    //首页修改信息
    @RequestMapping("/hometoedit")
    public String hometoedit(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        String str="";
        User user = userService.findRole(username);
        int role = user.getRole();
        if (role==1||role==0){
            out.print("<script language=\"javascript\">alert('对不起你没有这个权限')</script>");
            str="message";
        }
        else if(role==2||role==3){
            request.getSession().setAttribute("id3",id);
            return "homeedit";
        }
            return "redirect:/message";
    }
    @RequestMapping("homeedit")
    public String homeedit(Integer id,String title,String artical,HttpServletRequest request){
        id= (Integer) request.getSession().getAttribute("id3");
        messageService.myedit(id,title,artical);
        return "redirect:/message";
    }

    //管理员基于权限
    @RequestMapping("/admintorole")
    public String admintorole(Integer id,HttpServletRequest request){
        request.getSession().setAttribute("id3",id);
        return "adminrole";
    }
    @RequestMapping("/adminrole")
    public String adminrole(Integer id,Integer role,HttpServletRequest request){
        id= (Integer) request.getSession().getAttribute("id3");
        userService.editRole(id,role);
        return "redirect:/adminmessage";
    }

}
