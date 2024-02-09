package com.continental.javcon.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "play baseball";
    }

//    Get the name of the class
    public BaseBallCoach(){
        System.out.println("In contructor: " + getClass().getSimpleName());
    }
}

/*
* Bean scope, when we not create a Scope property it create a singleton concept even we create 2 references (private field in constroller)
* the default is ConfigurableBeanFactory is SCOPE_SINGLETON
* */