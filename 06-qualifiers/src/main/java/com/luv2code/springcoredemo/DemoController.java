package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //create a contructor in your class for injections
    @Autowired //@autowired anotasyonu sayesinde bir bean içerisindeki değerleri başka beanin içerisine enjekte edebilir
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {

        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
