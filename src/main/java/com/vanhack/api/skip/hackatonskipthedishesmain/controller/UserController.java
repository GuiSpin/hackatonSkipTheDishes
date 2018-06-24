package com.vanhack.api.skip.hackatonskipthedishesmain.controller;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.User;
import com.vanhack.api.skip.hackatonskipthedishesmain.repository.UserRepository;
import com.vanhack.api.skip.hackatonskipthedishesmain.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/public/users")
public class UserController {
    @Autowired
    private UserAuthenticationService authentication;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void register(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {

        final String uuid = UUID.randomUUID().toString();
        userRepository
                .save(
                        new User(username, password, uuid)

                );
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

}