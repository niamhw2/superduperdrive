package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller()
@RequestMapping("/signup")
public class SignupController {

    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating SignupController bean");
    }

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView() {
        return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        String signupError = null;

        logger.info("username:"+user.getUsername());
        logger.info("isUsernameavailable:"+userService.isUsernameAvailable(user.getUsername()));
        if (!userService.isUsernameAvailable(user.getUsername())) {
            signupError = "The username already exists.";
        }

        if (signupError == null) {
            logger.info("Creating user");
            int rowsAdded = userService.createUser(user);
            logger.info("rowsAdded: " + rowsAdded);
            if (rowsAdded < 0) {
                signupError = "There was an error signing you up. Please try again.";
            }
        }

        if (signupError == null) {
            logger.info("SignupSuccess");
            model.addAttribute("signupSuccess", true);
        } else {
            logger.info("SignupSuccess");
            model.addAttribute("signupError", signupError);
        }

        return "signup";
    }
}