package com.example.oenskeskyen.service;

import com.example.oenskeskyen.model.Wish;
import com.example.oenskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishRepo wishRepo;

    public List<Wish> fetchAll() {
        return wishRepo.fetchAll();
    }
}
