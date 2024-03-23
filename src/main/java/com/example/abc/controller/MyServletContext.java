package com.example.abc.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContext  {
    private static MyServletContext instance;

    public static MyServletContext getInstance(){
        if(instance == null) instance = new MyServletContext();
        return instance;
    }

    @Setter
    @Getter
    private ServletContext servletContext;
}
