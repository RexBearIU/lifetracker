package com.example.mapper;

import java.util.List;

// import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.bean.User;

@Mapper
public interface UserMapper {

    /**
     * table neme t_user.t_user is a must
     */
    public static final String INSERT_INTO_T_USER_VALUES = "insert into t_user.t_user values(null, #{name}, #{dailyCalories})";

    @Insert(INSERT_INTO_T_USER_VALUES)
    public int insert(User User);

    // @Delete("delete from t_user where id=#{id}")
    public int delectById(String id);

    public int update(User User);

    public User selectById(String id);

    public List<User> selectAll();

}
