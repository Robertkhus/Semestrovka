package ru.itis.repository.service;

import ru.itis.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrder();
    Optional<Order> getOrderById(int id);
    boolean addOrder(Order order);
    boolean deleteOrder(int id);

}
