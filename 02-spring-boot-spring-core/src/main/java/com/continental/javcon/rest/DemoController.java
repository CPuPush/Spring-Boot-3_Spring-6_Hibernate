package com.continental.javcon.rest;

import com.continental.javcon.common.BaseBallCoach;
import com.continental.javcon.common.Coach;
import com.continental.javcon.common.TennisCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // create a constructor in your class for injections
    // define a private field for dependency
//    @Autowired
    private Coach myCoach;
//    private TennisCoach tennisCoach;



    //! define a constructor for dependency injection
    // we cannot create 2 constructor with autowired .. but we can create setter injection for many autowired
    @Autowired
    public DemoController(@Qualifier("baseBallCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }
    //! define a setter method for setter injection
    //we can create 2 autowired with setter injection
//    @Autowired
//    public void setMyCoach(TennisCoach tennisCoach) {
//        this.tennisCoach = tennisCoach;
//    }
    //! define field injection
//    private Coach myCoach;
//    no need for constructor or setter
//    but adding the @Autowired annotation

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    test for 2 autowired with setter injection
//    @GetMapping("/test")
//    public String test(){
//        return tennisCoach.getDailyWorkout();
//    }

//    @GetMapping("/test-workout")
//    public String getHowMuch(){
//        return myCoach.getDailyWorkout() + myCoach.howMuch();
//    }
}
/*
* Autowired annotation tells Spring to inject a dependency,
* if only have one constructor then @Autowired on consturctor is OPTIONAL
*
* dari hasil pengamatan saya, injection yang dilakukan hanya sampai demoController, dimana sebetulnya dan harusnya restController dipanggil untuk di instantiate (var DemoController demoController = new DemoController(constructor)).. nah tetapi karena rest telah melakukan itu sendiri sehingga dibutuhkan penginjectkan
* note BUTUH PENJELASAN DETAIL MENGENAI INJECT DEPENDENCIES
*
* dan ternyata pernyataan saya benar,
* sehingga dibalik layar pemanggilan akan seperti berikut ini

var Coach myCoach = new CricketCoach();
var DemoController demoController = new DemoController(myCoach);
? new DemoController(myCoach); this is constructor injection concept that Spring handle that for us
? and     public DemoController(Coach myCoach) { this.myCoach = myCoach;} => this is our inject dependencies
*
*
! autowiring and Qualifiers
* Parameter 0 of constructor in com.continental.javcon.rest.DemoController required a single bean, but 4 were found:
* this is my analysis. why we should named the qualifier to lowercase? whynot make the same name as the name of file?
? because behind the spring, spring had initialized the file as the polimorfisme, and then we know the name of file sould camel case
* and why this is error, because there is 4 implementation from the interface, and spring confused which method to go for.
* this is why need qualifiers
* what if we wanna use another implementation without change the qualifier?
* use the setter injection for spesific components
* */