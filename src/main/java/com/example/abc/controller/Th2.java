package com.example.abc.controller;

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
        /*//目的:解析tag
        request.setAttribute("x","<span style=\"color:blue;\"> 你好</span>");
        //目的:做比較
        request.setAttribute("x2","你好2");

        User user = new User();
        user.setPwd("密碼:123");
        user.setUsername("姓名:某某某");
        model.addAttribute("user",user);
        //回傳前端(thymeleaf) -> th2.html。templates資料夾要存在。*/
        return "th2";
    }
}
