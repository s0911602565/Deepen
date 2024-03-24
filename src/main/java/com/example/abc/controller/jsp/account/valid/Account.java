package com.example.abc.controller.jsp.account.valid;


import com.example.abc.model.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("checkIt")
public class Account {

    @RequestMapping("doValid")
    public String doValid(@Valid User u, BindingResult r){
        if(r.hasErrors()){
            List<FieldError> fieldErrors = r.getFieldErrors();
            fieldErrors.forEach(x ->{
                System.out.println(x.getField() + " " + x.getDefaultMessage());// log
            });
            return "error_page";
        }
        System.out.println("登入成功");
        return "success_page";
    }

    @RequestMapping("c301")
    public String sendPage(){return "login";}
}






