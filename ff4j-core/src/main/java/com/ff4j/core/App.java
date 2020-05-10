package com.ff4j.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.uob.ff4j")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}