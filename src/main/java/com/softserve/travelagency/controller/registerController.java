package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registerController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "register";

    }
}
