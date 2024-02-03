package com.continental.javcon.rest;

import com.continental.javcon.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // create a constructor in your class for injections
    // define a private field for dependency
    @Autowired
    private Coach myCoach;



    //! define a constructor for dependency injection
//    @Autowired
//    public DemoController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }
    //! define a setter method for setter injection
//    @Autowired
//    public void setMyCoach(Coach myCoach) {
//        this.myCoach = myCoach;
//    }
    //! define field injection
//    private Coach myCoach;
//    no need for constructor or setter
//    but adding the @Autowired annotation

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
* dan ternyata pernyataan saya benar,
* sehingga dibalik layar pemanggilan akan seperti berikut ini

var Coach myCoach = new CricketCoach();
var DemoController demoController = new DemoController(myCoach);
? new DemoController(myCoach); this is constructor injection concept that Spring handle that for us
? and     public DemoController(Coach myCoach) { this.myCoach = myCoach;} => this is our inject dependencies
*
* */