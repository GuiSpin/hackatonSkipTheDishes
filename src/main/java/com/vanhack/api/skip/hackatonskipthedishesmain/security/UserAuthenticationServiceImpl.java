package com.vanhack.api.skip.hackatonskipthedishesmain.security;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.User;
import com.vanhack.api.skip.hackatonskipthedishesmain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<String> login(String username, String password) {
        User byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);

        return Optional.of(byUsernameAndPassword.getToken());
    }

    @Override
    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public void logout(User user) {

    }
}
