package com.continental.javcon.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "play baseball";
    }
}
