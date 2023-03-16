package com.example.mapper;

import java.util.List;
import java.sql.Timestamp;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.bean.DietRecord;
import com.example.bean.LifeUser;

import jakarta.annotation.Generated;

@Mapper
@Repository
public interface DietRecordMapper {

    /**
     * table neme t_user.life_user is a must
     */
    public static final String INSERT_INTO_T_USER_VALUES = "insert into t_user.life_user values(null, #{username}, #{email}, #{password})";

    @Options(useGeneratedKeys = true, keyProperty = "dietRecordId")
    @Insert("INSERT INTO t_user.diet_records VALUES (null, #{lifeUserId}, #{date}, #{mealTime}, #{food}, #{foodType}, #{portion}, #{calories})")
    public int insert(DietRecord dietRecord);

    @Delete("delete from t_user.diet_records where diet_record_id =#{DietRecordId}")
    public int delectById(Integer id);

    @Update("update t_user.diet_records set life_user_id = #{lifeUserId}, date = #{date}, meal_time = #{mealTime}, food = #{food}, food_type = #{foodType}, portion = #{portion}, calories = #{calories}  where diet_record_id =#{dietRecordId}")
    public int update(DietRecord dietRecord);

    @Select("select diet_record_id, life_user_id, date, meal_time, food, food_type, portion, calories from t_user.diet_records where diet_record_id =#{dietRecordId}")
    public DietRecord selectByDietRecordId(Integer id);

    @Select("select diet_record_id, life_user_id, date, meal_time, food, food_type, portion, calories from t_user.diet_records where life_user_id =#{lifeUserId}")
    public List<DietRecord> selectByLifeUserId(Integer id);

    @Select("select * from t_user.diet_records")
    public List<DietRecord> selectAll();

}
