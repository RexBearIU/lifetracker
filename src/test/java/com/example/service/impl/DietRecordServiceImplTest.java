package com.example.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bean.DietRecord;
import com.example.lifetracker.LifetrackerApplication;
import com.example.service.DietRecordService;

import jakarta.annotation.Resource;

@SpringBootTest(classes = LifetrackerApplication.class)
public class DietRecordServiceImplTest {

    @Resource
    DietRecordService dietRecordService;

    @Test
    void testCreateDietRecord() {
        DietRecord dietRecord = new DietRecord(null,4,LocalDate.parse("2023-03-16") , "Dinner", "Beef Salad", "Beef, yogurt", "1 cup", "200");
        boolean createDietRecord = dietRecordService.createDietRecord(dietRecord);
        System.out.println(createDietRecord);
    }

    @Test
    void testDelectDietRecord() {
        boolean delectDietRecord = dietRecordService.delectDietRecord(15);
        System.out.println(delectDietRecord);
    }

    @Test
    void testGetDietRecord() {
        List<DietRecord> dietRecord = dietRecordService.getDietRecord(4, "oneYear");          
        System.out.println(dietRecord);
    }

    @Test
    void testPutDietRecord() {
        DietRecord dietRecord = new DietRecord(12,4,LocalDate.parse("2023-03-09") , "Dinner", "Chicken Salad", "Chicken, yogurt", "1 cup", "200g");
        boolean putDietRecord = dietRecordService.putDietRecord(dietRecord);
        System.out.println(putDietRecord);
    }
}
