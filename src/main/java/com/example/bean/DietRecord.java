package com.example.bean;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DietRecord implements Comparable<DietRecord> {
    private Integer dietRecordId;
    private Integer lifeUserId;
    private LocalDate date;
    private String mealTime;
    private String food;
    private String foodType;
    private String portion;
    private String calories;

    
    public DietRecord() {
    }


    public DietRecord(Integer dietRecordId, Integer lifeUserId, LocalDate localDateParse, String mealTime, String food, String foodType,
            String portion, String calories) {
        this.dietRecordId = dietRecordId;
        this.lifeUserId = lifeUserId;
        this.date = localDateParse;
        this.mealTime = mealTime;
        this.food = food;
        this.foodType = foodType;
        this.portion = portion;
        this.calories = calories;
    }


    public Integer getDietRecordId() {
        return dietRecordId;
    }


    public void setDietRecordId(Integer dietRecordId) {
        this.dietRecordId = dietRecordId;
    }


    public Integer getLifeUserId() {
        return lifeUserId;
    }


    public void setLifeUserId(Integer lifeUserId) {
        this.lifeUserId = lifeUserId;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getMealTime() {
        return mealTime;
    }


    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }


    public String getFood() {
        return food;
    }


    public void setFood(String food) {
        this.food = food;
    }


    public String getFoodType() {
        return foodType;
    }


    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    public String getPortion() {
        return portion;
    }


    public void setPortion(String portion) {
        this.portion = portion;
    }


    public String getCalories() {
        return calories;
    }


    public void setCalories(String calories) {
        this.calories = calories;
    }


    @Override
    public String toString() {
        return "DietRecord [dietRecordId=" + dietRecordId + ", lifeUserId=" + lifeUserId + ", date=" + date
                + ", mealTime=" + mealTime + ", food=" + food + ", foodType=" + foodType + ", portion=" + portion
                + ", calories=" + calories + "]";
    }


    @Override
    public int compareTo(DietRecord dietRecord) {
        return this.getDate().compareTo(dietRecord.getDate());
    }



    
  
    
}
