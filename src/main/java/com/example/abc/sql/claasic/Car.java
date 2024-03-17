package com.example.abc.sql.claasic;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NonNull
    private String name;
    private String type;

    public Car(String name , String type){
        this.name = name;
        this.type = type;
    }
}
