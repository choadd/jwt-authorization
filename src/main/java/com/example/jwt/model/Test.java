package com.example.jwt.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
public class Test {

    @Id
    private Integer user;

}
