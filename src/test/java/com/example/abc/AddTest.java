package com.example.abc;

import com.example.abc.test._junit.j1.MyCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    //直接在這邊 Run 執行
    @Test
    @DisplayName("測試相加") // 跟print("show" 一樣意思
    void addsTow(){
        MyCalculator c = new MyCalculator();

        //先設定 pom (junit)
        //import static ... (才能使用assertEquals)
        //期待輸出值(內建的) ,
        //丟入方法
        assertEquals(2 , c.add(1 , 1));
    }
}
