package com.example.abc._lifecycle;

import org.junit.jupiter.api.*;

public class LifycycleOfTest {

    @Disabled
    @Test public void getTest1(){System.out.println("冠上 @Disabled 不被執行");}
    @Test public void getTest2(){System.out.println("--------------------------------------- ");}

    @BeforeAll public static void getBeforeAll(){System.out.println("@BeforeAll");}


    @BeforeEach public void getBeforeEach1(){System.out.println("@BeforeEach 1");}
    @BeforeEach public void getBeforeEach2(){System.out.println("@BeforeEach 2");}

    @AfterEach public void getAfterEach1(){System.out.println("@AfterEach 1");}
    @AfterEach public void getAfterEach2(){System.out.println("@AfterEach 2");}

    @AfterAll public static  void getAfterAll(){System.out.println("@AfterAll");}

    //重複n幾次
    //只會跑一次 @Test、@BeforeAll、@AfterAll
    //@RepeatedTest(3)public void getRepeatedTest(RepetitionInfo r){System.out.println("執行第:"+r.getCurrentRepetition()+"次");}



}
