package com.example.abc.test._sneakyThrows;

import lombok.SneakyThrows;

public class Thr1 {

    public void w1()throws Exception{}

    @SneakyThrows(Exception.class)
    public void w2(){
        w1();
    }
}
