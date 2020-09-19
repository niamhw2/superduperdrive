package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.controllers.SignupController;
import com.udacity.jwdnd.course1.cloudstorage.mappers.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private final UsersMapper userMapper;
    private final HashService hashService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating UserService bean");
    }

    public UserService(UsersMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable(String username) {
        logger.debug("returning isUserNameAvailable");
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        logger.debug("createUser method");
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        logger.debug("user getPassword");
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        logger.debug("Inserting User");
        return userMapper.insertUser(new User(null,
                user.getUsername(), encodedSalt,
                hashedPassword, user.getFirstname(), user.getLastname()));
    }

    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
