package com.example.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bean.DietRecord;
import com.example.bean.LifeUser;
import com.example.lifetracker.LifetrackerApplication;

import jakarta.annotation.Resource;

@SpringBootTest(classes = LifetrackerApplication.class)
public class DietRecordMapperTest {

    @Resource
    DietRecordMapper dietRecordMapper;

    @Test
    void testDelectById() {
        int delectById = dietRecordMapper.delectById(2);
    }

    @Test
    void testInsert() {
       
        DietRecord dietRecord = new DietRecord(null,5,LocalDate.parse("2023-04-18") , "Lunch", "Chicken Salad", "Chicken, yogurt", "1 cup", "200g");
        int insert = dietRecordMapper.insert(dietRecord);
    }

    @Test
    void testSelectAll() {
        List<DietRecord> selectAll = dietRecordMapper.selectAll();
        System.out.println(selectAll);
    }

    @Test
    void testSelectByDietRecordId() {
        DietRecord selectByDietRecordId = dietRecordMapper.selectByDietRecordId(3);
        System.out.println(selectByDietRecordId);
    }

    @Test
    void testSelectByLifeUserId() {
        List<DietRecord> selectByLifeUserId = dietRecordMapper.selectByLifeUserId(5);
        System.out.println(selectByLifeUserId);
    }

    @Test
    void testUpdate() {
        DietRecord dietRecord = new DietRecord(3,4,LocalDate.parse("2023-03-18") , "breakfast", "bubble milk tea", "milk, tea, bubble", "1 cup", "700c.c");
        int update = dietRecordMapper.update(dietRecord);
    }
}
