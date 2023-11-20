package com.example.abc.test;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String > x =null;
        x= Arrays.asList("a" , "b" , "c");
        System.out.println(x.size());
        for(String x1 : x){
            System.out.println(x1);
        }

    }
}
