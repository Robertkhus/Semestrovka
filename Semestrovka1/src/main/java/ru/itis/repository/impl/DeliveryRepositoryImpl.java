package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Delivery;
import ru.itis.repository.DeliveryRepository;
import ru.itis.repository.mapper.DeliveryRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Delivery> rowMapper = new DeliveryRowMapper();

    private static final String GET_ALL = "select * from delivery";
    private static final String GET_BY_ID = "select * from delivery where id=?";
    private static final String SAVE = "insert into delivery (order_id, delivery_address, status, tracking_number, delivery_date) values (?,?,?,?,?)";
    private static final String DELETE = "delete from delivery where id=?";

    public DeliveryRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Delivery> getAll() {
    return jdbcTemplate.execute(GET_ALL, rowMapper);
    }

    @Override
    public Optional<Delivery> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Delivery delivery) {
        return jdbcTemplate.submit(SAVE,delivery.getOrderId(),delivery.getDeliveryAddress(),delivery.getStatus(),delivery.getTrackingNumber(),delivery.getDeliveryDate());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id);
    }
}
