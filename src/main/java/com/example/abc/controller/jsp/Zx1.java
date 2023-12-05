package com.example.abc.controller.jsp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("zx1")
public class Zx1 {
    /**
     http://127.0.0.1:8080/zx1/zx1_method1
     * */
    @RequestMapping("zx1_method1")
    public ModelAndView zx1_method1(){
        //String 無法轉頁
        ModelAndView m = new ModelAndView("zx1");
        return m;
    }
}
