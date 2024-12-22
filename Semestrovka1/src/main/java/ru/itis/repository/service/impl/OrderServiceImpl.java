package ru.itis.repository.service.impl;

import ru.itis.entity.Order;
import ru.itis.repository.OrderRepository;
import ru.itis.repository.service.OrderService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.getAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderRepository.getById(id);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderRepository.delete(id);
    }
}
