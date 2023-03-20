package com.example.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.DietRecord;
import com.example.mapper.DietRecordMapper;
import com.example.service.DietRecordService;

import jakarta.annotation.Resource;

@Service
@Transactional
public class DietRecordServiceImpl implements DietRecordService {

    @Resource
    DietRecordMapper dietRecordMapper;

    @Override
    public boolean createDietRecord(DietRecord dietRecord) {

        int insert = dietRecordMapper.insert(dietRecord);

        if (insert < 1) {
            return false;
        }

        return true;
    }

    @Override
    public List<DietRecord> getDietRecord(Integer id, String period) {


        LocalDate now = LocalDate.now();
        LocalDate startDate = null;

        if ("sevenDays".equals(period)||period==null) {
            startDate = now.minusDays(7);
        }
        if ("oneMonth".equals(period)) {
            startDate = now.minusMonths(1);
        }
        if ("threeMonths".equals(period)) {
            startDate = now.minusMonths(3);
        }
        if ("oneYear".equals(period)) {
            startDate = now.minusYears(1);
        }
        List<DietRecord> selectByLifeUserIdAndDate = dietRecordMapper.selectByLifeUserIdAndDate(id, startDate, now);
        //* sort list without comparable class */
        // Collections.sort(dietRecord, new Comparator<DietRecord>(){
        //     @Override
        //     public int compare(DietRecord dietRecord1, DietRecord dietRecord2) {
        //         return dietRecord1.getDate().compareTo(dietRecord2.getDate());
        //     }
        // });        

        //* sort list with comparable class */
        Collections.sort(selectByLifeUserIdAndDate, Collections.reverseOrder());
        
        return selectByLifeUserIdAndDate;
    }

    @Override
    public boolean putDietRecord(DietRecord dietRecord) {
        int update = dietRecordMapper.update(dietRecord);

        if (update < 1) {
            return false;
        }

        return true;

    }

    @Override
    public boolean delectDietRecord(Integer id) {
        int delectById = dietRecordMapper.delectById(id);

        if (delectById < 1) {
            return false;
        }

        return true;
    }

    @Override
    public List<DietRecord> searchDietRecord(Integer lifeUserId,String food) {

        List<DietRecord> selectByFoodLike = dietRecordMapper.selectByFoodLike(lifeUserId,food);
        Collections.sort(selectByFoodLike, Collections.reverseOrder());
        return selectByFoodLike;
    }

}
