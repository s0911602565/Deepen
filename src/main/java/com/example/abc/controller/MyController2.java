package com.example.abc.controller;

import com.example.abc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController2 {
    /* 127.0.0.1:8080/c2/e1 */
    @RequestMapping("e1")
    public ModelAndView getMessage1(){
        User obj = new User();
        obj.setPwd("abc123");
        obj.setUsername("stephen");
        ModelAndView m = new ModelAndView("th1" );
        m.addObject("msg" , "請登入");
        m.addObject("myObj" , obj);
        return m;
    }
}
