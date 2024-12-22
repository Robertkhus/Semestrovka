package ru.itis.repository.service.impl;

import ru.itis.entity.User;
import ru.itis.repository.UserRepository;
import ru.itis.repository.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
