package com.sevval.thymeleafdemo.controller;

import com.sevval.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

    Student theStudent=new Student();

    //add student object to the model
    model.addAttribute("student",theStudent);
    model.addAttribute("countries",countries);
    model.addAttribute("languages",languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processSForm(@ModelAttribute("student") Student student){

        System.out.println("student: " +student.getFirstName()+ " " +student.getLastName());

    return "student-confirmation";

    }
}
