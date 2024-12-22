package ru.itis.repository.mapper;

import ru.itis.entity.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {

    public Cart mapRow(ResultSet resultSet) throws SQLException {
        return Cart.builder()
                .id(resultSet.getInt("id"))
                .userId(resultSet.getInt("user_id"))
                .productId(resultSet.getInt("product_id"))
                .quantity(resultSet.getInt("quantity"))
                .build();
    }
}
