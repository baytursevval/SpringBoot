package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component //spring bean olduğunu tanımlar
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "spend 30 min ";
    }
}
