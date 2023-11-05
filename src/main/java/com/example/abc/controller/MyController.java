package com.example.abc.controller;

import com.example.abc.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/handle")
public class MyController {

    /* http://127.0.0.1:8080/form.html  */
    @RequestMapping
    public String getMessage(
            @RequestParam(
                    name = "username" ,
                    required = false ,
                    defaultValue = "johnlee") String username ,
            @RequestParam String pwd){
        return "(handle) "+username + "/"+pwd;
    }

    /* http://127.0.0.1:8080/form.html */
    @RequestMapping("/obj")
    public String getMessage2(User user){
        return "(handle/obj) " +user.getUsername() + " " +user.getPwd();
    }


    //路徑變數 基本型別
    /* http://127.0.0.1:8080/form.html */
    @RequestMapping("/url/{id}/{userName}")
    public String getMessage3(
            @PathVariable("id") String p_Id,
            @PathVariable("userName") String p_UserName  ){
        return "getMessage3 "+p_UserName+ " "+  p_Id;
    }


    //路徑變數 map型態
    @RequestMapping("/url2/{id}/{userName}")
    public String getMessage4(@PathVariable Map pathMap){/* http://127.0.0.1:8080/form.html */
        System.out.println(pathMap.get("id"));
        System.out.println(pathMap.get("userName"));
        return "getMessage3 "+pathMap;
    }

    //檔案上傳
    /* http://127.0.0.1:8080/index.html */
    @RequestMapping("/files")
    public String getMessage5(@RequestPart(name="filez")MultipartFile mf){
        System.out.println(mf.getOriginalFilename());
        System.out.println(mf.getSize());
        System.out.println();
        return "myFile paht";
    }

    //檔案上傳
    /* http://127.0.0.1:8080/index.html */
    @RequestMapping("/files2")
    public String getMessage6(@RequestPart(name="filez") List<MultipartFile> mf){

        for (int i = 0 ; i < mf.size() ; i ++){
            MultipartFile mfs = mf.get(i);
            System.out.println(mfs.getOriginalFilename());
            System.out.println(mfs.getSize());
            System.out.println("----------");
        }
        return "myFile paht";
    }

    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head")
    public String getMessage7(@RequestHeader("User-Agent")String ua){
        System.out.println(ua);
        return "my Head:"+ua;
    }

    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head2")
    public String getMessage8(@RequestHeader Map ua){
        System.out.println(ua);
        return "my Head2:"+ua;
    }

}
