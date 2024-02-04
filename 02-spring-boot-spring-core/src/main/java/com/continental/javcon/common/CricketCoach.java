package com.continental.javcon.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//add lazy initialization
//@Lazy
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "play cricket";
    }

//    @Override
//    public int howMuch(){
//        return 12;
//    }
//    Get the name of the class
    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
}
/*
* Component annotation mark the class as a spring bean makes it available for dependency injection
*
! Autowiring explanation in this case
* injection in Coach implementation in DemoController
* Spring will scan for @components
* any one implements the coach interface
* if so, let's inject them.

! add lazy initialization
* lazy initialization for not instantiate directly but instdantiate when needed
* but if there is so many components, we need to create one by one lazy initialize, and this is so take time
* the solution is create global lazy initialization application.properties.
* tanpa lazy, the class initialized instantly
In contructor: BaseBallCoach
In constructor: CricketCoach
In constructor: TennisCoach
In constructor: TrackCoach
* with lazy in one class
In contructor: BaseBallCoach
In constructor: TennisCoach
In constructor: TrackCoach
* with lazy in global property there is no class initialized
* but when hit the enpoint in browser, the terminal will display the class that initialize
In contructor: BaseBallCoach
* */