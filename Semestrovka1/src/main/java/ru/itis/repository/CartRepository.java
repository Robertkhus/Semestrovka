package ru.itis.repository;

import ru.itis.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    List<Cart> getAll();

    Optional<Cart> getById(int id);

    boolean save(Cart cart);

    boolean delete(int id);
}
