package com.continental.javconapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    create Command Line Runner
    @Bean
    public CommandLineRunner commandLineRunner(String[] args){
        return runner  -> {
                System.out.println("Hello World");
        };
    }
}
/*
* CommandLineRunner Executed after the Spring beans have been loaded
* CommandLineRunner from the Spring Boot Framework
* the code using Java Lambda Expression, it's simply like a shortcut notation
* */