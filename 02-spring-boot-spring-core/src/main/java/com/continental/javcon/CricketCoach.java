package com.continental.javcon;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice fast push up 100x";
    }

    @Override
    public int howMuch(){
        return 12;
    }
}
/*
* Component annotation mark the class as a spring bean makes it available for dependency injection
* */