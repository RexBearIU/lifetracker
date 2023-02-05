package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;
    private Double dailyCalories;
    
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dailyCalories=" + dailyCalories + "]";
    }

    public User(int id, String name, Double dailyCalories) {
        this.id = id;
        this.name = name;
        this.dailyCalories = dailyCalories;
    }

    public User() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(Double dailyCalories) {
        this.dailyCalories = dailyCalories;
    }


}
