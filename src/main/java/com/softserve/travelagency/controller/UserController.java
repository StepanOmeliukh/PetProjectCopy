package com.softserve.travelagency.controller;

import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Getter
@Setter
@RequestMapping("/admin")
public class UserController {

    private UserService userService;

    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/getOrders")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getOrders(Model model, Long id) {

        return "orders";
    }

}
