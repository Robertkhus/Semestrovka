package ru.itis.repository.service;

import ru.itis.entity.Delivery;
import ru.itis.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReview();
    Optional<Review> getReviewById(int id);
    boolean addReview(Review review);
    boolean deleteReview(int id);
}
