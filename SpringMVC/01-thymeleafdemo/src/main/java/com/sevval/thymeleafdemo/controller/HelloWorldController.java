package com.sevval.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld2";
    }

    //add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String theName=request.getParameter("studentName");

        theName=theName.toUpperCase();

        String result= "Yo! " + theName;
        model.addAttribute("message", result);

        return "helloworld2";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName, //assign theName to value of request parameter
                                Model model) {


        theName=theName.toUpperCase();

        String result= "Hi from V3! " + theName;
        model.addAttribute("message", result);

        return "helloworld2";
    }
}
