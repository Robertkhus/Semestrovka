package ru.itis.repository.mapper;

import ru.itis.entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    public Review mapRow(ResultSet resultSet) throws SQLException {
        return Review.builder()
                .id(resultSet.getInt("id"))
                .userId(resultSet.getInt("user_id"))
                .productId(resultSet.getInt("product_id"))
                .comment(resultSet.getString("comment"))
                .reviewDate(resultSet.getDate("created_at"))
                .build();
    }
}
