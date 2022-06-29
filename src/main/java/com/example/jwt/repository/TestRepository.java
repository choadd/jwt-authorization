package com.example.jwt.repository;

import com.example.jwt.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,Integer> {
    List<Test> findAll();
}
