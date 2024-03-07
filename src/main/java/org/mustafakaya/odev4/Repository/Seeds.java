package org.mustafakaya.odev4.Repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Seeds implements CommandLineRunner {
    private final JdbcTemplate _jdbcTemplate;

    public Seeds(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO products (id, category, description, name, photo_url, price) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        _jdbcTemplate.update(sql, 100, "Tulum", "", "Bergama Tulum", "", 380);
        _jdbcTemplate.update(sql, 101, "Tulum", "", "Deri Tulum", "", 400);
        _jdbcTemplate.update(sql, 102, "Tulum", "", "İzmir Tulum", "", 320);
        _jdbcTemplate.update(sql, 103, "Tulum", "", "Tire Tulum", "", 280);
        _jdbcTemplate.update(sql, 104, "Ezine", "", "Çanakkale Ezine", "", 360);
        _jdbcTemplate.update(sql, 105, "Ezine", "", "Klasik Ezine", "", 320);
        _jdbcTemplate.update(sql, 106, "Ezine", "", "Yumuşak Ezine", "", 280);
        _jdbcTemplate.update(sql, 107, "Lor", "", "Kaşar Lor", "", 140);
        _jdbcTemplate.update(sql, 108, "Lor", "", "Tulum Lor", "", 110);
    }
}
