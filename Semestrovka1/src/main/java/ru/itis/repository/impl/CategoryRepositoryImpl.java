package ru.itis.repository.impl;

import ru.itis.config.DataSourceConfiguration;
import ru.itis.entity.Category;
import ru.itis.repository.CategoryRepository;
import ru.itis.repository.mapper.CategoryRowMapper;
import ru.itis.repository.mapper.RowMapper;
import ru.itis.repository.template.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Category> rowMapper = new CategoryRowMapper();

    private static final String GET_ALL =  "select * from category";
    private static final String GET_BY_ID =  "select * from category where id = ?";
    private static final String SAVE = "insert into category (name) values (?)";
    private static final String DELETE = "delete from category where id = ?";

    public CategoryRepositoryImpl() throws IOException {
        jdbcTemplate = new JdbcTemplate(DataSourceConfiguration.getInstance().getDataSource());
    }

    @Override
    public List<Category> getAll() {
        return jdbcTemplate.execute(GET_ALL, rowMapper);
    }

    @Override
    public Optional<Category> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.execute(GET_BY_ID,rowMapper,id).getFirst());
    }

    @Override
    public boolean save(Category category) {
        return jdbcTemplate.submit(SAVE,category.getName());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.submit(DELETE,id);
    }
}
