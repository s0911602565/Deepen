package com.example.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor 要搭配@NonNull(不能null) , 被標示的欄位,建構式會按照順序
public class User {
    private String username;
    private String pwd;
    private String pwd2;
    private String[] arr;
    private List<Amt> amt;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate birthdayA;




    public User(){
        this.setUsername("test123");
        this.setPwd("test321");
    }
    public User(String username){
        this.username = username;
    }

}
