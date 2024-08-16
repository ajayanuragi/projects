package dev.ajay.library.service.serviceimpl;

import dev.ajay.library.model.User;
import dev.ajay.library.repository.UserRepository;
import dev.ajay.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
    return user;
}

    public User updateUser(String username, User updatedUser) {
        Optional<User> optionalUser = getUserByUsername(username);

        if (optionalUser.isPresent()) {
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }

    public boolean deleteUser(String username) {
        Optional<User> optionalUser = getUserByUsername(username);

        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return true;
        } else {
            return false;
        }
    }
}
