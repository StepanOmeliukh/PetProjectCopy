package com.softserve.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String printWelcome() {
        return "hello";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }
}
