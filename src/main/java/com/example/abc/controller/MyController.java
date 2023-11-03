package com.example.abc.controller;

import com.example.abc.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/handle")
public class MyController {
    /* http://127.0.0.1:8080/form.html 測試 */
    @RequestMapping
    public String getMessage(
            @RequestParam(
                    name = "username" ,
                    required = false ,
                    defaultValue = "johnlee") String username ,
            @RequestParam String pwd){
        return "(handle) "+username + "/"+pwd;
    }

    /* http://127.0.0.1:8080/form.html */
    @RequestMapping("/obj")
    public String getMessage2(User user){
        return "(handle/obj) " +user.getUsername() + " " +user.getPwd();
    }

}
