package com.project.userssystem.service;

import com.project.userssystem.model.User;
import com.project.userssystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return repository.findById(id);
    }

    public User updateUser(Integer id, User user) {
        return repository.findById(id)
                .map(u -> {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    u.setEmail(user.getEmail());
                    u.setAge(user.getAge());
                    u.setAddress(user.getAddress());
                    return repository.save(u);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
}
