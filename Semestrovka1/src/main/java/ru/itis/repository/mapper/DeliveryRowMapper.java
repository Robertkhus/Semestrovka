package ru.itis.repository.mapper;

import ru.itis.entity.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryRowMapper implements RowMapper<Delivery> {

    public Delivery mapRow(ResultSet resultSet) throws SQLException {
        return Delivery.builder()
                .id(resultSet.getInt("id"))
                .orderId(resultSet.getInt("order_id"))
                .deliveryAddress(resultSet.getString("delivery_address"))
                .status(resultSet.getString("status"))
                .trackingNumber(resultSet.getString("tracking_number"))
                .deliveryDate(resultSet.getDate("delivery_date"))
                .build();
    }
}
