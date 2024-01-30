package com.continental.javcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // create a constructor in your class for injections
    // define a private field for dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/test-workout")
    public String getHowMuch(){
        return myCoach.getDailyWorkout() + myCoach.howMuch();
    }
}
/*
* Autowired annotation tells Spring to inject a dependency,
* if only have one constructor then @Autowired on consturctor is OPTIONAL
*
* dari hasil pengamatan saya, injection yang dilakukan hanya sampai demoController, dimana sebetulnya dan harusnya restController dipanggil untuk di instantiate (var DemoController demoController = new DemoContorller(constructor)).. nah tetapi karena rest telah melakukan itu sendiri sehingga dibutuhkan penginjectkan
* note BUTUH PENJELASAN DETAIL MENGENAI INJECT DEPENDENCIES
*
*
*
* */