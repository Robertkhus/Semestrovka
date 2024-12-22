package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Product;
import ru.itis.repository.ProductRepository;
import ru.itis.repository.mapper.ProductRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Product> rowMapper =  new ProductRowMapper();

    private static final String GET_ALL = "SELECT * FROM products ";
    private static final String GET_BY_ID = "SELECT * FROM products WHERE id = ?";
    private static final String SAVE = "INSERT INTO products (name, description, price, size, category_id) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM products WHERE id = ?";


    public ProductRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.execute(GET_ALL, rowMapper);
    }

    @Override
    public Optional<Product> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Product product) {
        return jdbcTemplate.submit(SAVE, product.getName(),product.getDescription(),product.getPrice(),product.getSize(),product.getCategory_id());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id);
    }
}
