package com.softserve.travelagency.controller;

import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Getter
@Setter
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }
}
