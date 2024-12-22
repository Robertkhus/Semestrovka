package ru.itis.repository.service.impl;

import ru.itis.entity.Review;
import ru.itis.repository.ReviewRepository;
import ru.itis.repository.service.ReviewService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.getAll();
    }

    @Override
    public Optional<Review> getReviewById(int id) {
        return reviewRepository.getById(id);
    }

    @Override
    public boolean addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteReview(int id) {
        return reviewRepository.delete(id);
    }
}
