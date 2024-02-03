package com.continental.javcon.common;

public interface Coach {

    String getDailyWorkout();

//    int howMuch();
}
/*
! Component Scanning note
* main spring app will scanning all the notation in the package/folder
* but in the com.love.util package never scanned so this project is error.
* but there is the solution to solving this by register this package to the main spring app
* */