package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "run a hard 10k!";
    }
}
