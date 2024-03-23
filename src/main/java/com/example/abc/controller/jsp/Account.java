package com.example.abc.controller.jsp;


import com.example.abc.model.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "login";
    }

    @RequestMapping("c301")
    public String sendPage(){return "login";}
}






