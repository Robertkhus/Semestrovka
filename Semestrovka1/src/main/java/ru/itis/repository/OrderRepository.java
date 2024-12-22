package ru.itis.repository;

import ru.itis.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();

    Optional<Order> getById(int id);

    boolean save(Order order);

    boolean delete(int id);

}
