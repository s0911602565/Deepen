package com.example.abc.model;

import com.example.abc.controller.jsp.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@FieldMatch(first = "pwd" , second = "pwd2")
public class User {
    @NotBlank(message = "帳號不為空")
    @Length(min = 8 ,max = 20,message = "帳號長度8-20")
    private String username;

    @NotBlank(message = "密碼不為空")
    private String pwd;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{8,100}$",message = "違反密碼政策")
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
