package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class LifeUser {
    
    private Integer id;
    private String name;
    private String password;
    private Double dailyCalories;
    
    

    @Override
    public String toString() {
        return "LifeUser [id=" + id + ", name=" + name + ", password=" + password + ", dailyCalories=" + dailyCalories
                + "]";
    }

    public LifeUser(int id, String name, Double dailyCalories) {
        this.id = id;
        this.name = name;
        this.dailyCalories = dailyCalories;
    }

    public LifeUser() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
