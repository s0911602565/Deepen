package com.example.abc.test._lambda;

import com.example.abc.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MakeData {
    ResponseEntity<Iterable<User>> setJson(int DAY);
}