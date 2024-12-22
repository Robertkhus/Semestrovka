package ru.itis.repository.service;

import ru.itis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    boolean addUser(User user);
    boolean deleteUser(int id);
}
