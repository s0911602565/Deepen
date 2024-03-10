package com.example.abc.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UseTheValue_Basic {
    @Value("${basic.username_1}")
    private String username;
    @Value("${basic.password_2}")
    private String password;

}
