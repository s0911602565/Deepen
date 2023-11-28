package com.example.abc.controller;
/*
ModelAndView
* */
import com.example.abc.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Th1 {
    /* 127.0.0.1:8080/ex1 */
    @RequestMapping("ex1")
    public ModelAndView getMessage1(){
        User obj = new User();
        obj.setPwd("abc123");
        obj.setUsername("stephen");

        //ModelAndView m = new ModelAndView("th1"); //這個OK

        boolean flag = false;
        if(flag)
            return method1(obj);//ModelAndView 方法1
            return method2(obj);//ModelAndView 方法2

    }
    public ModelAndView method1(User obj){
        Map<String , Object> map = new HashMap<>();
        map.put("msg" , "請登入A");
        map.put("myObj" , obj);
        ModelAndView m = new ModelAndView("th1" , map);
        return m;
    }

    public ModelAndView method2(User obj){
        ModelAndView m = new ModelAndView();
        m.addObject("msg" , "請登入B");
        m.addObject("myObj" , obj);
        m.setViewName("th1");
        return m;
    }
}
