package com.example.abc.test._lambda;

import lombok.Data;

interface Lam1_2{
    Lam1 create(String name);
}
@Data
public class Lam1{
    public Lam1(){}
    public Lam1(String n){
        this.n = n;
    }
    private String n;
    public static void main(String[] args) {
        Lam1_2 x = Lam1::new;
        Lam1 y = x.create("john");
        System.out.println(y.getN());
    }

}
