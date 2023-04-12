package com.example.oenskeskyen.controller;

import com.example.oenskeskyen.model.User;
import com.example.oenskeskyen.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    WishService wishService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/index")
    public String userPage(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model){
        if (wishService.userExist(username, password)){
            model.addAttribute("user", wishService.getUser(username, password));
            return "userpage";
        } else {
            model.addAttribute("error", "Forkert Brugernavn eller Adgangskode   ");
            return "index";
        }
    }
}
