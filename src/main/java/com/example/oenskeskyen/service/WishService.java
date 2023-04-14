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

    public List<Wish> fetchAllWishes(int wishlist_id) {
        return wishRepo.fetchAllWishes(wishlist_id);
    }

    public List<User> fetchAllUsers(){return wishRepo.fetchAllUsers();}

    public boolean userExist(String username, String password){
        return wishRepo.userExist(username, password);
    }

    public User getUser(String username){
        return wishRepo.getUser(username);
    }

    public List<Wishlist> fetchWishList(String username){
        return wishRepo.fetchAllWishlist(username);
    }
    public void addUser(User user){
        wishRepo.addUser(user);
    }
    public void addWishToWishlist(Wish wish,int wishlist_id){
        wishRepo.addWishToWishlist(wish, wishlist_id);
    }
    public void addWishlist(Wishlist wishlist, String username){
        wishRepo.addWishlist(wishlist, username);
    }
    public boolean userAlreadyExist(String username){
        return wishRepo.userAlreadyExist(username);
    }
}
