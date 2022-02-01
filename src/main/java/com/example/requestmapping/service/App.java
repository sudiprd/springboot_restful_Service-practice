package com.example.requestmapping.service;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class App {

    private String appName;
    private int appId;
    private String buildDate;
}
