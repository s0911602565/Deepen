package com.example.abc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface MyService1 {

    MyService2 getMyService2();
    void doSome();
}
