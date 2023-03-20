package com.example.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bean.DietRecord;
import com.example.lifetracker.LifetrackerApplication;

import jakarta.annotation.Resource;

@SpringBootTest(classes = LifetrackerApplication.class)
public class DietRecordMapperTest {

    @Resource
    DietRecordMapper dietRecordMapper;

    @Test
    void testDelectById() {
        int delectById = dietRecordMapper.delectById(2);
        System.out.println(delectById);
    }

    @Test
    void testInsert() {
       
        DietRecord dietRecord = new DietRecord(null,4,LocalDate.parse("2023-03-11") , "Lunch", "Chicken Salad", "Chicken, yogurt", "1 cup", "200g");
        int insert = dietRecordMapper.insert(dietRecord);
        System.out.println(insert);
    }

    @Test
    void testSelectAll() {
        List<DietRecord> selectAll = dietRecordMapper.selectAll();
        selectAll.forEach(dietRecord -> System.out.println(dietRecord));
    }

    @Test
    void testselectByLifeUserIdAndDate() {
        List<DietRecord> selectByLifeUserIdAndDate = dietRecordMapper.selectByLifeUserIdAndDate(4, LocalDate.parse("2023-03-05"), LocalDate.parse("2023-03-15"));
        System.out.println(selectByLifeUserIdAndDate);
    }

    @Test
    void testSelectByFood() {
        List<DietRecord> selectByLifeUserId = dietRecordMapper.selectByFoodLike(5,"Chicken");
        System.out.println(selectByLifeUserId);
    }

    @Test
    void testUpdate() {
        DietRecord dietRecord = new DietRecord(3,4,LocalDate.parse("2023-03-18") , "breakfast", "bubble milk tea", "milk, tea, bubble", "1 cup", "700c.c");
        int update = dietRecordMapper.update(dietRecord);
        System.out.println(update);
    }
    @Test
    void LocalDate() {
        System.out.println(LocalDate.now());
    }
}
