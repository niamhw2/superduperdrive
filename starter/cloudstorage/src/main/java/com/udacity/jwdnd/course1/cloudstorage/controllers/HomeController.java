package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.HomeForm;
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

    @GetMapping("/home")
    public String getData(HomeForm homeForm, Model model){
        model.addAttribute("uploadedCredentials",this.credentialService.getCredentials());
        model.addAttribute("uploadedFiles",this.fileService.getFiles());
        model.addAttribute("uploadedNotes",this.noteService.getNotes());
        return "home";
    }

}
