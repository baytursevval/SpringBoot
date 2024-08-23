package com.sevval.__validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {

        boolean result;

        if(code != null) {
            result=code.startsWith(coursePrefix);
        } else{
            result=true;
        }

        return result;
    }
}
