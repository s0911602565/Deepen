package com.example.abc.sql.dao.service;

import com.example.abc.sql.entity.Customer;
import com.example.abc.sql.entity.SignOrder;

import java.util.List;

public interface CarService {
    void deleteId(int id , String name);

    void deleteGroup(Customer customer , SignOrder signOrder);
}
