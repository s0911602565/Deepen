package com.example.abc.sql.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Toyota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    private String year;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car cars;
}
