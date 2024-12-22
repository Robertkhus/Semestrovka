package ru.itis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceConfiguration {

    private static DataSourceConfiguration instance;

    private static DataSource dataSource;

    private DataSourceConfiguration() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\husae\\IdeaProjects\\Semestrovka\\src\\main\\resources\\application.properties"));

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("database.url"));
        hikariConfig.setUsername(properties.getProperty("database.username"));
        hikariConfig.setPassword(properties.getProperty("database.password"));
        hikariConfig.setDriverClassName(properties.getProperty("database.driver-name"));
        hikariConfig.setMaximumPoolSize(
                Integer.parseInt(properties.getProperty("database.hikari.max-pool-size")));

        dataSource = new HikariDataSource(hikariConfig);
    }

    public static synchronized DataSourceConfiguration getInstance() throws IOException {
        if (instance == null) {
            instance = new DataSourceConfiguration();
        }
        return instance;
    }
    public DataSource getDataSource() {
        return dataSource;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
