package com.example.abc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


@SpringBootTest
class CallTheValues {
    @Autowired private UseTheValue_Basic basic;

    @Test
    public void seeValues1(){
        System.out.println("test1 "+basic.getUsername());
        System.out.println("test2 "+basic.getPassword());
    }

    @Autowired private UseTheValue1_Demo demo;

    @Tag("2024")
    @Test
    @DisplayName("測試value")
    public void seeValues2(){
        for (UseTheValue2_Demo obj2 :demo.getObj2()){
            System.out.printf("%s %s %s",obj2.getCode() ,obj2.getCity() , obj2.getHaveFun());
        }
    }


}