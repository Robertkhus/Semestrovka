package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.User;
import ru.itis.repository.UserRepository;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.mapper.UserRowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> rowMapper = new UserRowMapper();

    public UserRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    private static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SAVE = "INSERT INTO users (name, email, password, address, role, session_id) VALUES (?, ?,  ?, ?, ?, ?)";


    @Override
    public Optional<User> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.execute(GET_ALL, rowMapper);
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE_BY_ID,id);
    }

    @Override
    public boolean save(User user) {
        return jdbcTemplate.submit(SAVE,user.getName(),user.getEmail(),user.getPassword(),user.getAddress(),user.getSession_id(),user.getRole());
    }
}
