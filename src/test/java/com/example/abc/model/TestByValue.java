package com.example.abc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class TestByValue {
    @Autowired UseTheValue1_Demo demo;
    @Autowired UseTheValue_Basic basic;

    @Tag("demo20240318值測試")
    @Test
    @DisplayName("測試seeValues2")
    public void seeValues2() {
      for (UseTheValue2_Demo obj2 : demo.getObj2()) {
          assertEquals("台中" , obj2.getCity() , "輸出訊息...");
      }
    }

    @Tag("20240318by密碼")
    @Test
    @DisplayName("測試seeValues1")
    public void seeValues1(){
        assertNotNull(basic.getUsername());
    }
    /*
    @BeforeAll
    @BeforeEach
    @RepeatedTest
    */
}














