package com.example.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor //帶參數建構式
//@NoArgsConstructor //不帶參數建構式 (我已經寫一個沒參數建構式了)
public class User {
    @NotBlank(message="使用者為空")
    @Length(min = 4 , max = 6 , message = "使用者長度介於4到6字元")
    private String username;
    private String pwd;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDate birthdayA;
    public User(){
        this.setUsername("測試 ModelAttribute username");
        this.setPwd("測試 ModelAttribute pwd");
    }

}
