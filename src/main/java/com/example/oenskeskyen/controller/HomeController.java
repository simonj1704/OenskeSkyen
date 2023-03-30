package com.example.oenskeskyen.controller;

import ch.qos.logback.core.model.Model;
import com.example.oenskeskyen.model.Wish;
import com.example.oenskeskyen.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    WishService wishService;
    @GetMapping("/")
    public String index (Model model){
        List<Wish> wishList = wishService.fetchAll();
        return "index";
    }
}
