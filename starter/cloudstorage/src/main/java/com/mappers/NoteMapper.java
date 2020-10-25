package com.mappers;

import com.model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    Note getNote(int noteId);

    @Select("DELETE FROM NOTES WHERE noteId = #{noteId}")
    Note deleteNote(int noteId);

    @Select("SELECT * FROM NOTES")
    List<Note> getAllNotes();

    @Insert("INSERT INTO NOTES (notetitle,notedescription,userid) VALUES(#{notetitle},#{notedescription},#{userid}")
    @Options(useGeneratedKeys = true,keyProperty = "noteId")
            Integer insertNote(Note note);
}