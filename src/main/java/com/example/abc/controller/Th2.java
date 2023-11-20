package com.example.abc.controller;

import com.example.abc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Th2 {
    /**
     127.0.0.1:8080/home
     */
    @GetMapping({"home" , "home2"})
    public String home(HttpServletRequest request , Model model){
        request.setAttribute("x","<span style=\"color:blue;\"> 你好</span>");
        request.setAttribute("x2","你好2");

        User user = new User();
        user.setPwd("密碼:123");
        user.setUsername("姓名:某某某");
        model.addAttribute("user",user);

        //回傳前端(thymeleaf) -> th2.html
        return "th2";
    }
}
