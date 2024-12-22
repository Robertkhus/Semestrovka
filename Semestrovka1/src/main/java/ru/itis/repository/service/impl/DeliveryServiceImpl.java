package ru.itis.repository.service.impl;

import ru.itis.entity.Delivery;
import ru.itis.repository.DeliveryRepository;
import ru.itis.repository.service.DeliveryService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.getAll();
    }

    @Override
    public Optional<Delivery> getDeliveryById(int id) {
        return deliveryRepository.getById(id);
    }

    @Override
    public boolean addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public boolean deleteDelivery(int id) {
        return deliveryRepository.delete(id);
    }
}
