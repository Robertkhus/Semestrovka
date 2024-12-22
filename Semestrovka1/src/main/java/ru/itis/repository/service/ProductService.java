package ru.itis.repository.service;

import ru.itis.entity.Delivery;
import ru.itis.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();
    Optional<Product> getProductById(int id);
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
}
