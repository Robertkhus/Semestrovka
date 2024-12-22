package ru.itis.repository;

import ru.itis.entity.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {
    List<Delivery> getAll();

    Optional<Delivery> getById(int id);

    boolean save(Delivery delivery);

    boolean delete(int id);
}
