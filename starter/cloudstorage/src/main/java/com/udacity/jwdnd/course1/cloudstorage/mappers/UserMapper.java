package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mapper
public interface UserMapper {

        @Select("SELECT * FROM USERS WHERE username = #{username}")
        User getUser(String username);

        @Select("DELETE FROM USERS WHERE userid = #{userid}")
        User deleteUser(int userid);

        @Insert("INSERT INTO USERS (username,salt,password,firstname," +
                "lastname) VALUES(#{username},#{salt},#{password},#{firstname},#{lastname}) ")
        @Options(useGeneratedKeys = true,keyProperty = "userid")
        Integer insertUser(User user);
}
