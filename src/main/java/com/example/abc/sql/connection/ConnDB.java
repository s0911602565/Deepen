package com.example.abc.sql.connection;

import com.example.abc.sql.dao.CustomerRepository;
import com.example.abc.sql.dao.SignOrderRepository;
import com.example.abc.sql.dao.service.CarService;
import com.example.abc.sql.entity.Car;
import com.example.abc.sql.entity.Customer;
import com.example.abc.sql.entity.SignOrder;
import com.example.abc.sql.entity.Toyota;
import com.example.abc.sql.dao.CarRepository;
import com.example.abc.sql.dao.ToyotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("db")
public class ConnDB {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ToyotaRepository toyotaRepository;

    @RequestMapping("c1")
    public void doC1(){
        Car obj = new Car();
        obj.setName("j2");
        obj.setType("Toyota");
        carRepository.save(obj);
    }
    /*
    127.0.0.1:8080/db/c2
    */
    @RequestMapping("c2")
    public void doC2() throws Exception{
        Optional<Car> obj = carRepository.findById(3);
        Car car = null;
        if(obj.isPresent()){
            car = obj.get();
        }else{
            car = new Car("car3" , "lev3");
            carRepository.save(car);
        }
        Toyota toyota = new Toyota();
        toyota.setCars(car);
        toyota.setName("atis");
        toyota.setPrice(80d);
        toyota.setYear("2024");
        toyotaRepository.save(toyota);
    }

    @Autowired CustomerRepository customerRepository;
    @Autowired SignOrderRepository signOrderRepository;
    @Autowired CarService carService;

    @RequestMapping("c3")
    public void testConnectionSQL(){
        Optional<Customer> o1 = customerRepository.findById(2);
        Optional<SignOrder> o2 = signOrderRepository.findById(3);
        carService.deleteGroup(o1.get() , o2.get());
    }
}

