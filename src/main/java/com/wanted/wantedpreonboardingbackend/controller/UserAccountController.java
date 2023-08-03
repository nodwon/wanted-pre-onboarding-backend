package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserAccountController {
    private final UserService userService;

    @GetMapping("users/new")
    public String createFrom(Model model){
        model.addAttribute("userForm", new UserForm());
        return "users/createUserFrom";
    }
}
