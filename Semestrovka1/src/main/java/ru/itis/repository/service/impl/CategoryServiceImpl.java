package ru.itis.repository.service.impl;

import ru.itis.entity.Category;
import ru.itis.repository.CategoryRepository;
import ru.itis.repository.service.CategoryService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAll();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryRepository.delete(id);
    }
}
