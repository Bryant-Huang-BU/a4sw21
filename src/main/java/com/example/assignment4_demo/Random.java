package com.example.assignment4_demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= Random.TABLE_NAME)
public class Random {

    public static final String TABLE_NAME = "RANDOM";
    @Id
    @GeneratedValue(generator = TABLE_NAME + "_GENERATOR")
    @SequenceGenerator(
            name = TABLE_NAME + "_GENERATOR",
            sequenceName = TABLE_NAME + "_SEQUENCE"
    )
    @Column(name = "RANDOM_ID")
    long id;
    @Column(name = "DATA")
    String data;
    public void setID(long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public long getID() {
        return id;
    }
}
