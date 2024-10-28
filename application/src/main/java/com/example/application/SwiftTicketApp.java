package com.example.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SwiftTicketApp extends SpringBootServletInitializer {


    @Value("{spring.data.mongodb.uri}")
    public static  String url;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

        return application.sources(SwiftTicketApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SwiftTicketApp.class, args);
    }
}


