package com.example.abc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestByValue {
    @Autowired UseTheValue1_Demo demo;
    @Autowired UseTheValue_Basic basic;

    @Tag("d20240318")
    @Test
    @DisplayName("測試seeValues2")
    public void seeValues2() {
      for (UseTheValue2_Demo obj2 : demo.getObj2()) {
        System.out.printf("%s %s %s \n"
                , obj2.getCode(), obj2.getCity(), obj2.getHaveFun());
      }
    }
    @Tag("sss")
    @Test
    @DisplayName("測試seeValues1")
    public void seeValues1(){
        System.out.printf(" %s %s \n",basic.getUsername() ,basic.getPassword());
    }
}