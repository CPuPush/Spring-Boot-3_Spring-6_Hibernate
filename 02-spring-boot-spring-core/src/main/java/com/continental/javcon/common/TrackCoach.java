package com.continental.javcon.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Play TrackCoach";
    }
}
