package com.example.abc.model;

import com.example.abc.controller.Th3;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor //帶參數建構式
@Th3(firs = "pwd" , second = "pwd2" , msg = "密碼1、2需要相同!")
//@NoArgsConstructor //不帶參數建構式 (我已經寫一個沒參數建構式了)

public class User {
    @NotBlank(message="使用者為空")
    @Length(min = 4 , max = 6 , message = "使用者長度介於4到6字元")
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

}
