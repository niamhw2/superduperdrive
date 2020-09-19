package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mappers.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CredentialService {

    private CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating CredentialService bean");
    }

    public List<Note> getCredentials() {
        return credentialMapper.getAllCredentials();
    }

    public void addNote(Credential credential){
        credentialMapper.insertCredentials(credential);
    }
}
