package com.example.abc.model;

import lombok.Data;

@Data
public class Amt /*extends User 也可以唷 */ {
    private String id;
    private String money;
    public Amt(){

    }
    public Amt(String id , String money){
        this.id = id;
        this.money = money;
    }
}
