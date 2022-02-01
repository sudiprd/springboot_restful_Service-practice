package com.example.requestmapping.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Customer {

    private String name;
    private int id;
    private String department;



}
