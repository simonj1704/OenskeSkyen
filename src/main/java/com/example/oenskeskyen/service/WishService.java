package com.example.oenskeskyen.service;

import com.example.oenskeskyen.model.User;
import com.example.oenskeskyen.model.Wish;
import com.example.oenskeskyen.model.Wishlist;
import com.example.oenskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishRepo wishRepo;

    public List<Wish> fetchAllWishes() {
        return wishRepo.fetchAllWishes();
    }

    public List<User> fetchAllUsers(){return wishRepo.fetchAllUsers();}

    public boolean userExist(String username, String password){
        return wishRepo.userExist(username, password);
    }

    public User getUser(String username){
        return wishRepo.getUser(username);
    }

    public List<Wishlist> fetchWishList(String username){
        List<Wishlist> list = wishRepo.fetchAllWishlist(username);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return wishRepo.fetchAllWishlist(username);
    }
}
