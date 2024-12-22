package ru.itis.repository;

import ru.itis.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    List<Review> getAll();

    Optional<Review> getById(int id);

    boolean save(Review review);

    boolean delete(int id);


}
