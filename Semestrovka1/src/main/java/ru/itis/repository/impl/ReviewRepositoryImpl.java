package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Order;
import ru.itis.entity.Review;
import ru.itis.repository.ReviewRepository;
import ru.itis.repository.mapper.OrderRowMapper;
import ru.itis.repository.mapper.ReviewRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ReviewRepositoryImpl implements ReviewRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Review> rowMapper = new ReviewRowMapper();

    private static final String GET_ALL = "SELECT * FROM reviews";
    private static final String GET_BY_ID = "SELECT * FROM reviews WHERE id = ?";
    private static final String SAVE = "insert into reviews (user_id, product_id, comment, created_at) values (?, ?, ?, ?)";
    private static final String DELETE = "delete from reviews where id = ?";

    public ReviewRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Review> getAll() {
        return jdbcTemplate.execute(GET_ALL,rowMapper);
    }

    @Override
    public Optional<Review> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Review review) {
        return jdbcTemplate.submit(SAVE,review.getUserId(),review.getProductId(),review.getComment());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id);
    }
}
