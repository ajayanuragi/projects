package dev.ajay.library.service;

import dev.ajay.library.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    Optional<User> getUserByUsername(String username);

    List<User> findAllUser();
}
