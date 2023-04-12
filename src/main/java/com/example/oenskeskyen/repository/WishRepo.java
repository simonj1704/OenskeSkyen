package com.example.oenskeskyen.repository;

import com.example.oenskeskyen.model.User;
import com.example.oenskeskyen.model.Wish;
import com.example.oenskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishRepo {

    @Autowired
    JdbcTemplate template;

    public List<Wish> fetchAllWishes(){
        String sql = "SELECT * FROM wishes";
        RowMapper<Wish> rowMapper = new BeanPropertyRowMapper<>(Wish.class);
        return template.query(sql, rowMapper);
    }

    public List<User> fetchAllUsers(){
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);
    }

    public boolean userExist(String username, String password){
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND BINARY passcode = ?";
        return template.queryForObject(sql, Integer.class,username, password) > 0;
    }

    public User getUser(String username){
        String sql = "SELECT * FROM users WHERE username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.queryForObject(sql, rowMapper, username);
    }

    public List<Wishlist> fetchAllWishlist(String username){
        String sql = "SELECT * FROM wishlist WHERE user_id =(SELECT user_id FROM users WHERE username = ?)";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return template.query(sql, rowMapper, username);
    }
}
