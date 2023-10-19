package com.example.assignment4_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RandomService {
    @Autowired
    private RandomRepository rR;

    public Optional<Random> findRandom (Long id) {
        return rR.findById(id);
    }
}
