package com.example.abc.sql.dao;


import com.example.abc.sql.BasicRepository;
import com.example.abc.sql.claasic.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarRepository extends BasicRepository<Car, Integer> {
    @Query(value = " select new map(name as name ,type as type)from Car where name=?1 and type=?2 ")
    public List getAllCarData2( String name , String type);
}
