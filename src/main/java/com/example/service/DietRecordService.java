package com.example.service;


import com.example.bean.DietRecord;


public interface DietRecordService {
    

    public boolean createDietRecord(DietRecord dietRecord);
    
    public DietRecord getDietRecord(Integer id);

    public boolean putDietRecord(DietRecord dietRecord);

    public boolean delectDietRecord(Integer id); 
        
}
