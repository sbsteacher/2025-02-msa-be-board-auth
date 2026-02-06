package com.green.boardauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BoardAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardAuthApplication.class, args);
    }

}
