package com.example.abc.test._lambda;

import com.example.abc.model.Amt;

import java.util.List;
import java.util.stream.Collectors;

public class Lam2 {
    public static void main(String[] args) {

        List<Amt> a = List.of(  new Amt("1" , "100") ,
                                new Amt("2" , "200") ,
                                new Amt("3" , "300"));
        List<String> list = a
                .stream()
                .map(Amt::getMoney)
                .collect(Collectors.toList());

        list.forEach(x->{
            System.out.println("金額:" + x);
        });
    }
}
