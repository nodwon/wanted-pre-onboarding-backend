package com.wanted.wantedpreonboardingbackend.controller;

import com.wanted.wantedpreonboardingbackend.domain.UserAccount;
import com.wanted.wantedpreonboardingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserAccountController {

    private final UserService userService;
    @GetMapping("/login")
    public String createFrom(Model model){
        model.addAttribute("UserForm", new UserForm());
        return "users/createUserForm";
    }
    public String create(@Valid UserForm userForm, BindingResult result){
        if(result.hasErrors())
        {
            return "members/createUserForm";
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(userForm.getEmail());
        userAccount.setUserPassword(userForm.getUserPassword());
        userService.join(userAccount);
        return "redirect:/";
    }

}
