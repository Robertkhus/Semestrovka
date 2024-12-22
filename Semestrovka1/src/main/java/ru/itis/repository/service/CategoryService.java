package ru.itis.repository.service;


import ru.itis.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(int id);
    boolean addCategory(Category category);
    boolean deleteCategory(int id);
}
