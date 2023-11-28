package com.example.abc.controller;

import com.example.abc.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("Index4")
public class Index4 {

    /* http://127.0.0.1:8080/index4.html
    * @Valid 與User類別，搭配使用
    * BindingResult:使用這個類別 ，就不會直接在html顯示錯誤訊息
    * pom.xml:spring-boot-starter-validation
    * */
    @RequestMapping("getMessage1")
    public String getMessage1(@Valid User user , BindingResult r) {
        if(r.hasErrors()){
            System.out.println("只要沒填寫 username 或介於 4-6字元 就會= True ");
        }else{
            System.out.println(user.getUsername());
        }
        return "Index4_getMessage1:";
    }

}
