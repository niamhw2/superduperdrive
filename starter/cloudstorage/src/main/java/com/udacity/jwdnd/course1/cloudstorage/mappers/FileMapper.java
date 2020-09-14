package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface FileMapper {

            @Select("SELECT * FROM FILES WHERE filename = #{filename}")
            File getFile(String filename);

            @Select("DELETE FROM FILES WHERE filename = #{filename}")
            File deleteFilename(String filename);

            @Insert("INSERT INTO FILES (filename,contenttype,filesize,userid," +
                    "filedata) VALUES(#{filename},#{contenttype},#{filesize},#{userid},#{filedata}) ")
            @Options(useGeneratedKeys = true,keyProperty = "fileId")
            Integer insertUser(File file);
}
