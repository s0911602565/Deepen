package com.example.abc.controller;

import com.example.abc.sql.dao.CarRepository;
import com.example.abc.sql.dao.LoginRepository;
import com.example.abc.sql.entity.Car;
import com.example.abc.sql.entity.Login;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@WebFilter(urlPatterns = "/*" ,filterName = "compressionFilter")
public class MyWebFilter implements Filter{

    private final CarRepository carRepository;
    private final LoginRepository loginRepository;
    public MyWebFilter(CarRepository s , LoginRepository s1){
        this.carRepository = s;
        this.loginRepository = s1;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest r =(HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        HttpSession session = r.getSession();
        Object carID = session.getAttribute("carID");
        if(carID != null){
            int id = Integer.parseInt(carID.toString());
            Optional<Car> obj = carRepository.findById(id);
            if(obj.isPresent()){
                Car car = obj.get();
                Login l = new Login();
                l.setBought(car.getName());
                l.setTime(new Date());
                loginRepository.save(l);

                session.invalidate();
            }
        }
        filterChain.doFilter(r , rs);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
