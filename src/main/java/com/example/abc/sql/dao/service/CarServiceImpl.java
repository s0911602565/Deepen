package com.example.abc.sql.dao.service;

import com.example.abc.sql.dao.CarRepository;
import com.example.abc.sql.entity.Customer;
import com.example.abc.sql.entity.SignOrder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;

    @Override
    public void deleteId(int id, String name) {
        carRepository.deleteOne(id , name);
    }

    @Override
    public void deleteGroup(Customer customer , SignOrder signOrder){
        carRepository.deleteMany(customer , signOrder);
    }

    @Override
    public int findGroup(Customer customer , SignOrder signOrder){
        return carRepository.findCount(customer , signOrder);
    }
}















