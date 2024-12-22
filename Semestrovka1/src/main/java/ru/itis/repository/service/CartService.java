package ru.itis.repository.service;

import ru.itis.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getAllCart();
    Optional<Cart> getCartById(int id);
    boolean addCart(Cart cart);
    boolean deleteCart(int id);

}
