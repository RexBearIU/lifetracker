package com.example.service;


import java.util.List;

import com.example.bean.DietRecord;


public interface DietRecordService {
    

    public boolean createDietRecord(DietRecord dietRecord);
    
    public List<DietRecord> getDietRecord(Integer id, String period);

    public boolean putDietRecord(DietRecord dietRecord);

    public boolean delectDietRecord(Integer id);
    
    public List<DietRecord> searchDietRecord(Integer lifeUserId,String food);
        
}
