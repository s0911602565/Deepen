package com.example.abc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@ConfigurationProperties(prefix = "hard")
@Data
public class UseTheValue1_Hard {
    private int id;
    private String name;
    private List hobby;
    private List drink;
    private Map food;
    private List<UseTheValue2_Hard> obj2;
}
