package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component //spring bean olduğunu tanımlar
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice fast !!";
    }

}
