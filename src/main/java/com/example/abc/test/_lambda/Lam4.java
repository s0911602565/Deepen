package com.example.abc.test._lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Stream.of
//Collectors.joining
//map
public class Lam4 {
    public static void main(String[] args) {
        lam1();
        lam2();
        lam3();
        lam4();
    }

    public static void lam1(){
        Integer[] r = new Integer[]{1 , 2};
        Stream.of(r).map(x -> x+1).forEach(System.out::println);
    }
    public static void lam2(){
        String[] r = new String[]{"john" , "lee" , "tom"};
        String x1 = Stream.of(r).map(Object::toString).collect(Collectors.joining(","));
        System.out.println(x1);
    }
    public static void lam3(){
        System.out.println("lam3------------");
        List<String> strList = new ArrayList<String>();
        strList.add("john");
        strList.add("toms");
        //一般
        List<String> list2 = strList.stream().map(s -> "姓名:"+s).collect(Collectors.toList());
        list2.stream().forEach(x->{
            System.out.println(x);
        });
        //字串、加入逗號
        String lamStringXX = strList.stream().map(s -> "姓名:"+s).collect(Collectors.joining(","));
        System.out.println(lamStringXX);
    }

    public static void lam4(){
        System.out.println("lam4------------");
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(111);
        intList.add(123);
        List<Integer> list = intList.stream().map(x -> x+1 ).collect(Collectors.toList());
        list.forEach(x->{
            System.out.println(x);
        });

    }

}
