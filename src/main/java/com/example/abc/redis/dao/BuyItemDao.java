package com.example.abc.redis.dao;

import com.example.abc.redis.entity.BuyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuyItemDao {
    @Autowired
    private RedisTemplate redisTemplate;
    public static final String KEY = "BuyItem";
    public BuyItem save(BuyItem obj){
        redisTemplate.opsForHash().put(KEY , obj.getId() , obj);
        return obj;
    }

    public List<BuyItem> findAll(){

        return redisTemplate.opsForHash().values(KEY);
    }
}
