package com.example.abc.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("zx2")
public class Zx2 {
    /**
     http://127.0.0.1:8080/zx2/zx2_method1
     * */
    @RequestMapping("zx2_method1")
    public String zx2_method1(){
        return "zx2";
    }

    @RequestMapping("/zx2_method2/{id}")
    public String zx2_method2(@PathVariable String id){
        System.out.println("zx2 show id:"+id);
        return "zx2";
    }
}
