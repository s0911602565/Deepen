package com.example.abc.controller;
/*

@RequestParam
@PathVariable
@RequestBody (json)
@RequestPart 上傳檔案
@RequestHeader 標頭-資訊
* */
import com.example.abc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("handle")
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

    /*
    開啟 post man ,  http://127.0.0.1:8080/handle/json
    * */
    @RequestMapping("/json")
    public ResponseEntity<User> getJson(){
        User user2 = new User();
        user2.setPwd("123123");
        user2.setUsername("john1ee");
        return new ResponseEntity<User>(user2 , HttpStatus.OK);
    }

    /*
    以下貼到post man , 以及使用網址進行取得資料  http://127.0.0.1:8080/handle/json2
    {
    "username":"john",
    "pwd":"123"
    }
    */
    @RequestMapping("/json2")
    public void getJson2(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPwd());
    }


    //取得-路徑變數 map型態
    @RequestMapping("/url2/{id}/{userName}")
    public String getMessage4(@PathVariable Map pathMap){/* http://127.0.0.1:8080/form.html */
        System.out.println(pathMap.get("id"));
        System.out.println(pathMap.get("userName"));
        return "getMessage4 "+pathMap;
    }

    //檔案上傳(1個)
    /* http://127.0.0.1:8080/index.html */
    @RequestMapping("/files")
    public String getMessage5(@RequestPart(name="filez")MultipartFile mf){
        System.out.println(mf.getOriginalFilename());
        System.out.println(mf.getSize());
        System.out.println();
        return "myFile paht";
    }

    //檔案上傳(n個)
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

    /*取得(User-Agent)標頭-資訊 Head */
    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head")
    public String getMessage7(@RequestHeader("User-Agent")String ua){
        System.out.println(ua);
        return "my Head:"+ua;
    }

    /*取得(所有)標頭-資訊 Head */
    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head2")
    public String getMessage8(@RequestHeader Map ua){
        System.out.println(ua);
        return "my Head2:"+ua;
    }

}
