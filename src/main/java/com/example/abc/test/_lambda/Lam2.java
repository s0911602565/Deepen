package com.example.abc.test._lambda;

import com.example.abc.model.Amt;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lam2 {
    public static void main(String[] args) {

        List<Amt> a = List.of(  new Amt("1" , "100") ,
                                new Amt("2" , "200") ,
                                new Amt("3" , "300"));
        List<String> list = a
                .stream()
                .filter(x -> Integer.parseInt(x.getMoney())  >  100)
                .map(Amt::getMoney)
                .collect(Collectors.toList());

        //組合出List
        list.forEach(x->{
            System.out.println("金額:" + x);
        });

        //組合出Set
        Set<String> set = Stream.of("a","b","c").collect(Collectors.toSet());
        set.forEach( (x)->{
            System.out.println("set :"+x);
        });

        Map<String,String> map = new TreeMap<>();
        map.put("a" , "b");
        map.put("a2" , "b2");
        map.put("a3" , "b3");

        //使用 () ->
        map.forEach( (k,v) ->{
            System.out.println("key:"+k + " value:" +v);
        });

    }
}
