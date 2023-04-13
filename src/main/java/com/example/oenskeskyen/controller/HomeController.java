package com.example.oenskeskyen.controller;

import com.example.oenskeskyen.model.User;
import com.example.oenskeskyen.service.WishService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                           Model model, HttpSession session){
        if (wishService.userExist(username, password)){
            model.addAttribute("user", wishService.getUser(username));
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", true);
            return "redirect:/userpage";
        } else {
            model.addAttribute("error", "Forkert Brugernavn eller Adgangskode   ");
            return "index";
        }
    }

    @GetMapping("/userpage")
    public String userpage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn == null || !isLoggedIn) {
            return "redirect:/login";
        } else {
            String username = (String) session.getAttribute("username");
            model.addAttribute("user", wishService.getUser(username));
            model.addAttribute("wishlist", wishService.fetchWishList(username));
            return "userpage";
        }
    }
    @PostMapping("createUser")
    public String createUser(@ModelAttribute User user){
        wishService.addUser(user);
        return "redirect: index";
    }

    @GetMapping("/viewWishList/{id}")
    public String viewWishList(@PathVariable("id") int id, Model model){
        return "wishList";
    }
}
