package ru.itis.repository.mapper;

import ru.itis.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet resultSet) throws SQLException {
        return Order.builder()
                .id(resultSet.getInt("id"))
                .userId(resultSet.getInt("userId"))
                .status(resultSet.getString("status"))
                .totalPrice(resultSet.getDouble("total_price"))
                .orderDate(resultSet.getDate("orderdate"))
                .deliveryDate(resultSet.getDate("deliverydate"))
                .build();
    }
}
