package com.example.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor //跟 @RequiredArgsConstructor 做比對
//@RequiredArgsConstructor 要搭配@NonNull(不能null) , 被標示的欄位,建構式會按照順序
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
