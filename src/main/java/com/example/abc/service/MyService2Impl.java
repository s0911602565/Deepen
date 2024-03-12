package com.example.abc.service;

import org.springframework.stereotype.Service;

@Service
public class MyService2Impl implements MyService2{
    @Override
    public void doSome2() {
        System.out.println("doSome2");
    }
}
