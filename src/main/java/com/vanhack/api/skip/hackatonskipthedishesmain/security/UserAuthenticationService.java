package com.vanhack.api.skip.hackatonskipthedishesmain.security;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.User;

import java.util.Optional;

public interface UserAuthenticationService {
    Optional<String> login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    Optional<User> findByToken(String token);

    /**
     * Logs out the given input {@code user}.
     *
     * @param user the user to logout
     */
    void logout(User user);
}
