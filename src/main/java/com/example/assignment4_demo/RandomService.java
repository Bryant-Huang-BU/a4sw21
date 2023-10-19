package com.example.assignment4_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RandomService {
    @Autowired
    private RandomRepository rR;

    public Optional<Random> findRandom (Long id) {
        return rR.findById(id);
    }
    public List<String> findAllValues () {
        List<Random> rList = rR.findAll();
        List<String> sList = new ArrayList<String>(rList.size());
        for (int i = 0; i < rList.size(); i++) {
            sList.add(rList.get(i).getData());
        }
        return sList;
    }
    public void saveRandom(String s) {
        Random r = new Random(s);
        rR.save(r);
    }
}
