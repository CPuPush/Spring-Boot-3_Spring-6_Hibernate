package com.continental.javcon.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Play TrackCoach";
    }
//    Get the name of the class
    public TrackCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
}
