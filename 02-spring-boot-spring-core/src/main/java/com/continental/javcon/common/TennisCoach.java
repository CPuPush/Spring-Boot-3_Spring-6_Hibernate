package com.continental.javcon.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "play tennis";
    }
}
