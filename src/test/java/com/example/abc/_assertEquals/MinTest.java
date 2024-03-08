package com.example.abc._assertEquals;
import com.example.abc.test._junit.j1.MyCalculator;

//junit5 版本

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


//junit4 版本
/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
*/

public class MinTest {
    @Tag("development")
    @Test
    @DisplayName("測試相減") // 跟print("show" 一樣意思
    public void minsTow(){
        MyCalculator c = new MyCalculator();

        //先設定 pom (junit)
        //import static ... (才能使用assertEquals)
        //期待輸出值(內建的) ,
        //丟入方法
        assertEquals(99 , c.min(100 , 1));
    }
}
