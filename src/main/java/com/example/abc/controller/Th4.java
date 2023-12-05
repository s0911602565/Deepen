package com.example.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("th4")
public class Th4 {
    /**
     http://127.0.0.1:8080/th4/th4_method1
     * */
    @RequestMapping("th4_method1")
    public String th4_method1(){
        return "th4";
    }
}
