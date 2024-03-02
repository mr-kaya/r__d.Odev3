package org.mustafakaya.odev3.Service;

import org.mustafakaya.odev3.Core.DTO.ProductDto;
import org.mustafakaya.odev3.Core.Repositories.IProductRepository;
import org.mustafakaya.odev3.Core.Services.IProductService;
import org.mustafakaya.odev3.Repository.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository _productRepository;
    private final JdbcTemplate _jdbcTemplate;

    public ProductService(IProductRepository productRepository, JdbcTemplate jdbcTemplate) {
        _productRepository = productRepository;
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return _jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
    }
    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {

        return _jdbcTemplate.query("SELECT * FROM products WHERE category = ?", new Object[] {categoryName}, new ProductMapper());
    }
}
