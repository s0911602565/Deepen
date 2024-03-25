package com.example.abc.sql.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;

    //Policy Customer
    @ManyToOne
    @JoinColumn(name = "signorderId", nullable = false)
    private SignOrder signOrder;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


    public Car(String name , String type){
        this.name = name;
        this.type = type;
    }
}
