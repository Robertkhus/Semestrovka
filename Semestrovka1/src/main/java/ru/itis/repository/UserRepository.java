package ru.itis.repository;

import ru.itis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> getById(int id);

    List<User> getAll();

    boolean delete(int id);

    boolean save(User user);
}
