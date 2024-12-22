package ru.itis.repository;

import ru.itis.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<Product> getById(int id);

    boolean save(Product product);

    boolean delete(int id);
}
