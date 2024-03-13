package org.mustafakaya.odev6.Repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Seeds implements CommandLineRunner {
    private final JdbcTemplate _jdbcTemplate;

    public Seeds(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String sql = "INSERT INTO product (id, category, description, create_date, update_date, name, photo_url, price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        _jdbcTemplate.update(sql, 100, "Tulum", "", timestamp, timestamp, "Bergama Tulum", "", 380);
        _jdbcTemplate.update(sql, 101, "Tulum", "", timestamp, timestamp, "Deri Tulum", "", 400);
        _jdbcTemplate.update(sql, 102, "Tulum", "", timestamp, timestamp, "İzmir Tulum", "", 320);
        _jdbcTemplate.update(sql, 103, "Tulum", "", timestamp, timestamp, "Tire Tulum", "", 280);
        _jdbcTemplate.update(sql, 104, "Ezine", "", timestamp, timestamp, "Çanakkale Ezine", "", 360);
        _jdbcTemplate.update(sql, 105, "Ezine", "", timestamp, timestamp, "Klasik Ezine", "", 320);
        _jdbcTemplate.update(sql, 106, "Ezine", "", timestamp, timestamp, "Yumuşak Ezine", "", 280);
        _jdbcTemplate.update(sql, 107, "Lor", "", timestamp, timestamp, "Kaşar Lor", "", 140);
        _jdbcTemplate.update(sql, 108, "Lor", "", timestamp, timestamp, "Tulum Lor", "", 110);
    }
}
