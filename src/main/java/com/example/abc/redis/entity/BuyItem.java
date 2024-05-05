package com.example.abc.redis.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("BuyItem")
public class BuyItem implements Serializable {
    @Id
    private int id;
    private String name;
    private Double price;
}
