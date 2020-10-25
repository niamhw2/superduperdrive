package com.mappers;

import com.model.Credential;
import com.model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE username = #{username}")
    Credential getCredentials(String username);

    @Select("DELETE FROM CREDENTIALS WHERE username = #{username}")
    Credential deleteCredentials(String username);

    @Insert("INSERT INTO CREDENTIALS (userid,url,username,key," +
            "password) VALUES(#{userid},#{url},#{username},#{key},#{password}) ")
    @Options(useGeneratedKeys = true,keyProperty = "credentialid")
    Integer insertCredentials(Credential credential);

    @Select("SELECT * FROM CREDENTIALS")
    List<Note> getAllCredentials();
}
