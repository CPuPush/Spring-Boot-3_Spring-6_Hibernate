package com.continental.javcon.common;


public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Do swiming";
    }


}


/*
* This class is experiment, but i confuse because we can use without using the return new in bean annotation
* maybe this is running because just a simple code without using a third party.
* i will analyst this in the next section
* */
