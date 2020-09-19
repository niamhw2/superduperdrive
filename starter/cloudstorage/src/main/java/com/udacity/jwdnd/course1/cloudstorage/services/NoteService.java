package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating NoteService bean");
    }

    public List<Note> getNotes() {
        return noteMapper.getAllNotes();
    }

    public void addNote(Note originalNote){
        noteMapper.insertNote(originalNote);
    }


}
