package com.example.abc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@ConfigurationProperties(prefix = "demo")
@Data
public class UseTheValue1_Demo {
    private int id;
    private String name;
    private List hobby;
    private List drink;
    private Map food;
    private List<UseTheValue2_Demo> obj2;
}
