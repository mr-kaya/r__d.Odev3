package org.mustafakaya.odev3.Repository;

import org.mustafakaya.odev3.Core.DTO.ProductDto;
import org.mustafakaya.odev3.Core.Entity.ProductEntity;
import org.mustafakaya.odev3.Core.Repositories.IProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final JdbcTemplate _jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return null;
    }

    @Override
    public List<ProductEntity> getProductsByCategory(String categoryName) {
        return null;
    }
}
