package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;
    private String dailyCalories;
    private String daily_calories;  // have to solve
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dailyCalories=" + dailyCalories + ", daily_calories="
                + daily_calories + "]";
    }



    public User(int id, String name, String dailyCalories, String daily_calories) {
        this.id = id;
        this.name = name;
        this.dailyCalories = dailyCalories;
        this.daily_calories = daily_calories;
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
    public String getDailyCalories() {
        return dailyCalories;
    }
    public void setDailyCalories(String dailyCalories) {
        this.dailyCalories = dailyCalories;
    }



    public String getDaily_calories() {
        return daily_calories;
    }



    public void setDaily_calories(String daily_calories) {
        this.daily_calories = daily_calories;
    }


}
