package com.example.oenskeskyen.controller;

import com.example.oenskeskyen.model.User;
import com.example.oenskeskyen.model.Wishlist;
import com.example.oenskeskyen.model.Wish;
import com.example.oenskeskyen.service.WishService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    WishService wishService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        if(wishService.userAlreadyExist((String) session.getAttribute("tried_username"))){
            model.addAttribute("show_popup1", true);
            model.addAttribute("error_username", "Username already exists");
            return "index";
        } else {
            return "index";
        }
    }

    @PostMapping("/index")
    public String userPage(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model, HttpSession session) {
        if (wishService.userExist(username, password)) {
            model.addAttribute("user", wishService.getUser(username));
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", true);
            return "redirect:/userpage";
        } else {
            model.addAttribute("error", "Forkert Brugernavn eller Adgangskode");
            return "index";
        }
    }

    @GetMapping("/userpage")
    public String userpage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn == null || !isLoggedIn) {
            return "redirect:/index";
        } else {
            String username = (String) session.getAttribute("username");
            model.addAttribute("user", wishService.getUser(username));
            model.addAttribute("wishlist", wishService.fetchWishList(username));
            return "userpage";
        }
    }

    @GetMapping("/myprofile")
    public String myProfile(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        model.addAttribute("user", wishService.getUser(username));
        return "myprofile";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("isLoggedIn", false);
        session.invalidate();
        return "redirect:/index";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, Model model, HttpServletRequest request){
        if (wishService.userAlreadyExist(user.getUsername())){
            HttpSession session = request.getSession();
            session.setAttribute("tried_username", user.getUsername());
            return "redirect:/index#popup1";
        } else {
            wishService.addUser(user);
            return "redirect:/index";

        }
    }


    @PostMapping("/createWishlist")
    public String createWishlist(@ModelAttribute Wishlist wishlist, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        wishService.addWishlist(wishlist, username);
        return "redirect:/userpage";
    }

    @GetMapping("/viewWishList/{wishlist_id}")
    public String viewWishList(@PathVariable("wishlist_id") int wishlist_id, Model model) {
        List<Wish> wishList = wishService.fetchAllWishes(wishlist_id);
        model.addAttribute("wishes", wishList);
        model.addAttribute("wishlist", wishlist_id);
        return "wishList";
    }

    @GetMapping("/addWish/{wishlist_id}")
    public String addWish(@ModelAttribute Wish wish, @PathVariable("wishlist_id") int wishlist_id) {
        wishService.addWishToWishlist(wish, wishlist_id);
        return "redirect:/viewWishList/" + wishlist_id;
    }

}
