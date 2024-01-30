package com.continental.javcon.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FunRestController {
    // expose "/" that return "Hello Programmer"
    @Value("${coach.test}")
    private String coachTest;
    @GetMapping("/")
    public String sayProgrammer(){
        return "Hello Programmer " + coachTest;
    }

    // expose a new endpoint for test the dev-tools for automatically reload the project without rerun the project
    @GetMapping("/coach")
    public String saycoach(){
        return "testing this file oke perubahan dimulai";
    }

    //expose new endpoint
    @GetMapping("/testing")
    public String sayTest(){
        return "test";
    }
}