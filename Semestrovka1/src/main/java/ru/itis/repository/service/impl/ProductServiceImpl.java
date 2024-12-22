package ru.itis.repository.service.impl;

import ru.itis.entity.Product;
import ru.itis.repository.ProductRepository;
import ru.itis.repository.service.ProductService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return productRepository.save(product);
    }
}
