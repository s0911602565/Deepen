package com.example.abc.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class UseTheValue_BasicTest {
    @Autowired
    private UseTheValue_Basic u;
    @Test
    void test(){
        System.out.println("test1 "+u.getUsername());
        System.out.println("test2 "+u.getPassword());
    }
}