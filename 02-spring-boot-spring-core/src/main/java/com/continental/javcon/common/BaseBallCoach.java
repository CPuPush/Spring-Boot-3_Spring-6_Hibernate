package com.continental.javcon.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "play baseball";
    }
}
