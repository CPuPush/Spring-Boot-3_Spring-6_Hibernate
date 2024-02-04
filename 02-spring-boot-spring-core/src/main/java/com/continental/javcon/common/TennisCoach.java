package com.continental.javcon.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "play tennis";
    }
    //    Get the name of the class
    public TennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
}
