package com.example.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("ser1")
public class ExcuteMyService {

    @Autowired
    private  MyService1 m;

    /*
    http://127.0.0.1:8080/ser1/ser2
     */
    @RequestMapping("ser2")
    public void doMessage(){
        m.doSome();
        m.getMyService2().doSome2();
    }

}
