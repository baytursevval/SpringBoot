package com.luv2code.util;

import org.springframework.stereotype.Component;

@Component //spring bean olduğunu tanımlar
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice fast !!";
    }

}
