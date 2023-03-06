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

import com.example.bean.LifeUser;

import jakarta.annotation.Generated;

@Mapper
@Repository
public interface UserMapper {

    /**
     * table neme t_user.life_user is a must
     */
    public static final String INSERT_INTO_T_USER_VALUES = "insert into t_user.life_user values(null, #{username}, #{email}, #{password})";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(INSERT_INTO_T_USER_VALUES)
    public int insert(LifeUser User);

    @Delete("delete from t_user.life_user where id =#{id}")
    public int delectById(Integer id);

    @Update("update t_user.life_user set username = #{username}, email = #{email}, password = #{password} where id = #{id}")
    public int update(LifeUser User);

    @Select("select id, username, email, password from t_user.life_user where id = #{id}")
    public LifeUser selectById(Integer id);

    @Select("select id, username, email, password from t_user.life_user where email = #{email}")
    public LifeUser selectByEmail(String email);

    @Select("select * from t_user.life_user")
    public List<LifeUser> selectAll();

}
