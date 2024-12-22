package ru.itis.repository.mapper;

import ru.itis.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .session_id((UUID) resultSet.getObject("session_id"))
                .address(resultSet.getString("address "))
                .role(resultSet.getString("role"))
                .build();
    }
}
