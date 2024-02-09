package com.continental.javcon.config;

import com.continental.javcon.common.Coach;
import com.continental.javcon.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
//    give a custom bean id
    @Bean("beanidtest")
    public Coach swimCoach(){
//        return new SwimCoach
        return new SwimCoach();
    }
}

/*
* This is useful for SwimCoach that not using @Component annotation

Coach (interface)
SwimCoach (implement Coach) there is constructor with no params,

SportConfig => return new
*
* */