package com.example.abc.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

//@RequiredArgsConstructor  被指定不可空
//@AllArgsConstructor       所有欄位
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NonNull
    @Column(name = "clientname")
    private String clientName;
}
