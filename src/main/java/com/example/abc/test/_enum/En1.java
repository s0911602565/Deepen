package com.example.abc.test._enum;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

interface X<T> {
    T getSome();
}


enum A implements X<String>{
    county("1", "市縣");

    A(String number, String 市縣) {

    }

    //@Getter
    private String some;
    public String getSome(){return this.some;}
}

public class En1 {
}
