package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/register"})
    public String register() {
        return "register";
    }


    //登陆方法
    @RequestMapping("/addlogin")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("username",username);
        String str = "";
        User user = userService.findUserByUsername(username);
        if (username.equals("admin")&&password.equals("admin")){
            return "redirect:/adminmessage";
        }
        else if (user!=null){
            User user1 = userService.findUserByPassword(password);
            if (user1!=null){
                return "redirect:/message";
            }
            else {
                int failnum = 1;
                user.setFailnum(failnum);
                return "register";
            }

        }
        else {
            int failnum = 0;
            failnum +=1;
            user.setFailnum(failnum);
            return "register";
        }

    }

    @RequestMapping("/addregister")
    public String registerUser(String username,String password){
        userService.register(username,password);
        return "redirect:/login";
    }

}
