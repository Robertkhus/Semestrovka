package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Cart;
import ru.itis.repository.CartRepository;

import ru.itis.entity.Cart;
import ru.itis.repository.CartRepository;
import ru.itis.repository.mapper.CartRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import java.util.List;

public class CartRepositoryImpl implements CartRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Cart> rowMapper = new CartRowMapper();

    private static final String GET_ALL = "select * from cart";
    private static final String GET_BY_ID = "select * from cart where id = ?";
    private static final String SAVE = "insert into cart (user_id, product_id, quantity) values (?, ?, ?)";
    private static final String DELETE = "delete from cart where id = ?";

    public CartRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Cart> getAll() {
        return jdbcTemplate.execute(GET_ALL,rowMapper);
    }

    @Override
    public Optional<Cart> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Cart cart) {
        return jdbcTemplate.submit(SAVE,cart.getUserId(),cart.getProductId(),cart.getQuantity());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id);
    }
}
