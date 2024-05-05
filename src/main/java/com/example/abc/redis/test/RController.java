package com.example.abc.redis.test;

import com.example.abc.redis.dao.BuyItemDao;
import com.example.abc.redis.entity.BuyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("r1")
public class RController {
    @Autowired BuyItemDao dao;

    @RequestMapping("r2")
    public BuyItem save(@RequestBody BuyItem obj){
        dao.save(obj);
        return obj;
    }

    /*
    127.0.0.1:8080/r1/r3
    */
    @RequestMapping("r3")
    public List<BuyItem> findAll(){

        List list =  dao.findAll();
        for(int i = 0 ; i < list.size() ; i++){
            BuyItem obj = (BuyItem)list.get(i);
            System.out.println(obj.getName() + " " + obj.getId());
        }
        return dao.findAll();
    }

}
