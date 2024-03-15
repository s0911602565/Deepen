package com.example.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyService1Impl implements MyService1{

    @Autowired
    private MyService2 m2;
    public MyService2 getMyService2(){
       return m2;
    }

    //啟動前初始化
    @PostConstruct
    public void initSomething(){
        System.out.println("init...");
    }

    @Override
    public void doSome() {
        System.out.println("doSome");
    }
}
