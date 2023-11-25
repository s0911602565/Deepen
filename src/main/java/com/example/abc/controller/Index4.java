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
    * */
    @RequestMapping("getMessage1")
    public String getMessage1(@Valid User user , BindingResult r) {
        System.out.print(r.hasErrors());
        System.out.println(" 只要沒填寫 username 就 = true");

        System.out.println(user.getUsername());
        System.out.println(user.getPwd());
        return "Index4_getMessage1:";
    }

}
