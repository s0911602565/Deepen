package com.example.abc.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BasicRepository<T, ID extends Serializable> extends JpaRepository<T , ID> {}
