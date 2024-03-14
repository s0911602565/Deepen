package com.example.abc.controller;
// @ResponseBody

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cwz")
public class MyController {
    /*
    方法:@ResponseBody
    目的:如何使用
    說明:
    a. @Controller                  + return "index"    轉頁
    b. @Controller + @ResponseBody  + return "index"    等同 @RestController 回傳(字串、json)
    c. return ResponseEntity                            等同 b.
    */
    @RequestMapping("ctr1")
    //@ResponseBody
    public String doSome(){
        return "zx1";
    }

}
