package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE username = #{username}")
    Credential getCredentials(String username);

    @Select("DELETE FROM CREDENTIALS WHERE username = #{username}")
    Credential deleteCredentials(String username);

    @Insert("INSERT INTO CREDENTIALS (userid,url,username,key," +
            "password) VALUES(#{userid},#{url},#{username},#{key},#{password}) ")
    @Options(useGeneratedKeys = true,keyProperty = "credentialid")
    Integer insertCredentials(Credential credential);
}
