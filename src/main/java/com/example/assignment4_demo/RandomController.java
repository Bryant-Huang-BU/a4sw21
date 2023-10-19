package com.example.assignment4_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RestController
public class RandomController {
    @Autowired
    private RandomService rS;
    @GetMapping(value = "/generate_random")
    public String generateRandom() {
    int x = (int)(Math.random() * 1000);
    String result = Integer.toString(x);
    rS.saveRandom(result);
    //String insertSql = "INSERT INTO random_data (data) VALUES (?)";
    //jdbcTemplate.update(insertSql, result);

    return result;
    }
    @GetMapping(value = "/show_random")
    public List<String> showRandom() {

            /*String sql = "SELECT * FROM random_data";
            List<Random> randomers = new ArrayList<>();
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            List<String> truelist = new ArrayList<>();
            for (Map row : rows) {
                Random obj = new Random();
                obj.setID(((Integer) row.get("ID")).longValue());
                obj.setData(row.get("DATA").toString());
                randomers.add(obj);
                truelist.add(obj.getData());
            }*/
            return rS.findAllValues();
        }
    }
