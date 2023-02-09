package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.bean.User;

@Mapper
@Repository
public interface UserMapper {

    /**
     * table neme t_user.t_user is a must
     */
    public static final String INSERT_INTO_T_USER_VALUES = "insert into t_user.t_user values(null, #{name}, #{dailyCalories})";

    @Insert(INSERT_INTO_T_USER_VALUES)
    public int insert(User User);

    @Delete("delete from t_user.t_user where id =#{id}")
    public int delectById(int id);

    @Update("update t_user.t_user set name = #{name}, daily_Calories = #{dailyCalories} where id = #{id}")
    public int update(User User);

    @Select("select id, name, daily_calories from t_user.t_user where id =#{id}")
    public User selectById(int id);

    @Select("select * from t_user.t_user")
    public List<User> selectAll();

}
