package ru.itis.repository.service;

import ru.itis.entity.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery> getAllDelivery();
    Optional<Delivery> getDeliveryById(int id);
    boolean addDelivery(Delivery delivery);
    boolean deleteDelivery(int id);

}
