package com.example.restapi_lesson_42.service;

import com.example.restapi_lesson_42.repository.UserRepository;
import com.example.restapi_lesson_42.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public Optional<User> findUserById(long id){
        return userRepository.findById(id);
    }

    public void updateUsername(long id, String username) {
       userRepository.updateUserByUsername(id, username);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }
}
