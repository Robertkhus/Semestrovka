package ru.itis.repository;

import ru.itis.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();

    Optional<Category> getById(int id);

    boolean save(Category category);

    boolean delete(int id);



}
