package com.vanhack.api.skip.hackatonskipthedishesmain.repository;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByToken(String token);
}
