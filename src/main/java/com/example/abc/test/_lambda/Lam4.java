package com.example.abc.test._lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lam4 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        List<Integer> intList = new ArrayList<Integer>();
        strList.add("john");
        strList.add("toms");

        intList.add(111);
        intList.add(123);

        List list2 = strList.stream().map(s -> "姓名:"+s).collect(Collectors.toList());
        list2.forEach(System.out::println);


        List list3 = intList.stream().map(x -> x+1 ).collect(Collectors.toList());
        list3.forEach(x->{
            System.out.println(x);
        });


    }
}
