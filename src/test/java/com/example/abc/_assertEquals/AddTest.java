package com.example.abc._assertEquals;

import com.example.abc.test._junit.j1.MyCalculator;

//junit5 版本

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

//junit4 版本
/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
*/
public class AddTest {
    //直接在這邊 Run 執行
    @Tag("production") // (TestJu5.java)
    @Test
    @DisplayName("測試相加") // 等同 print("show" 的 show
    public void addsTow(){
        MyCalculator c = new MyCalculator();

        //先設定 pom (junit 5)
        //import static ... (才能使用assertEquals)
        //內建所期待的int(自己指定的) , 方法回傳int(自己寫的方法) , 出錯訊息

        //a.
        assertEquals(2 , c.add(1 , 1) , "我是錯誤訊息...");// 判斷方法回傳int是否相同

        //b.
        Supplier<String> error = () -> "我是錯誤訊息...";
        assertNotEquals(1 , c.add(1 , 1) , error);// 判斷方法回傳int是否不同

        //c.
        int[]x = new int[]{1,2,3};
        int[]y = new int[]{1,2,3};
        assertArrayEquals(x , y , "我是錯誤訊息"); //兩個陣列是否相同

        //d.
        String strNotNull = "";
        String strNull = null;
        assertNotNull(strNotNull); //物件不能是null
        assertNull(strNull);//物件是null


    }
}
