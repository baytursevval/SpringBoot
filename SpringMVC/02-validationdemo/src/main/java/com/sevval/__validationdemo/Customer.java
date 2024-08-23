package com.sevval.__validationdemo;

import com.sevval.__validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message = "is requiredd")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater or equal to zero")
    @Max(value = 10, message = "must be less or equal to 10")
    private Integer freePasses; //Integer:temelde bir wrapper classı

    private String postalCode;

    private String courseCode;
    @CourseCode(value = "TOPS", message = "must start with TOPS")
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Pattern(regexp = "[a-zA-Z0-9]{5}", message = "only 5 digits/chars")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
}
