package ru.itis.repository.service.impl;

import ru.itis.entity.Cart;
import ru.itis.repository.CartRepository;
import ru.itis.repository.service.CartService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    @Override
    public Optional<Cart> getCartById(int id) {
        return cartRepository.getById(id);
    }

    @Override
    public boolean addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public boolean deleteCart(int id) {
        return cartRepository.delete(id);
    }

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.getAll();
    }
}
