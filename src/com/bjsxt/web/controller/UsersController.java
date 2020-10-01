package com.bjsxt.web.controller;

import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExt;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UsersController {
        @Autowired
        private UsersService usersService;


            /**
            * 处理用户登录请求
            */
            @RequestMapping("/userLogin")
            public String userLogin(UsersExt users, HttpSession session, HttpServletRequest request){
                System.out.println("进入到方法----------------");
                String ip = request.getRemoteAddr();
                users.setIp(ip);
                Users user = this.usersService.userLogin(users);
                session.setAttribute("user",user);
                return "redirect:/page/index";
            }
}