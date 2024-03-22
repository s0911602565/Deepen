package com.example.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Amt {
    private String id;
    private String money;
    private Season season;
    public Amt(Season season){
        this.season = season;
    }
    public Amt(String id , String money){
        this.id = id;
        this.money = money;
    }
}
