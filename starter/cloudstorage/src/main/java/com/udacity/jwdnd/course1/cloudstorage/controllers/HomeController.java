package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    private NoteService noteService;
    private CredentialService credentialService;
    private FileService fileService;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating HomeController bean");
    }

    public HomeController(NoteService noteService, CredentialService credentialService, FileService fileService) {
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }

    //Note
    @GetMapping("/home")
    public String getData(@ModelAttribute("Note") Note note, Model model){
        model.addAttribute("uploadNotes",this.noteService.getNotes());
        return "home";
    }

    //Credential
    public String getData(@ModelAttribute("Credential") Credential credential, Model model){
        model.addAttribute("uploadCredentials",this.credentialService.getCredentials());
        return "home";
    }

    //File
    public String getData(@ModelAttribute("File") File file, Model model){
        model.addAttribute("uploadFiles",this.fileService.getFiles());
        return "home";
    }

}
