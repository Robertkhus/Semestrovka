package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Order;
import ru.itis.repository.OrderRepository;
import ru.itis.repository.mapper.OrderRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Order> rowMapper = new OrderRowMapper();

    private static final String GET_ALL = "select * from orders";
    private static final String GET_BY_ID = "select * from orders where id = ?";
    private static final String SAVE = "insert into orders (user_id, total_price, status, order_date, delivery_date) values (?, ?, ?, ?, ?)";
    private static final String DELETE = "delete from orders where id = ?";

    public OrderRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.execute(GET_ALL, rowMapper);
    }

    @Override
    public Optional<Order> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Order order) {
        return jdbcTemplate.submit(SAVE, order.getUserId(),order.getTotalPrice(),order.getStatus(),order.getOrderDate(),order.getDeliveryDate());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id );
    }
}
