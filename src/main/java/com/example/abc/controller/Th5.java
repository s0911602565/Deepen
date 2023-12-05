package com.example.abc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping("th5")
public class Th5 {
    /**
     http://127.0.0.1:8080/th5/th5_method1
     * */
    @RequestMapping("th5_method1")
    public ModelAndView th5_method1(){
        //String 無法轉頁
        ModelAndView m = new ModelAndView("th5");
        return m;
    }
}
