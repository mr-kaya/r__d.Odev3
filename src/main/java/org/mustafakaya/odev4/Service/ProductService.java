package org.mustafakaya.odev4.Service;

import org.mustafakaya.odev4.Core.DTO.ProductDto;
import org.mustafakaya.odev4.Core.Entity.ProductEntity;
import org.mustafakaya.odev4.Core.Repositories.IProductRepository;
import org.mustafakaya.odev4.Core.Services.IProductService;
import org.mustafakaya.odev4.Repository.ProductMapper;
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

    @Override
    public Long postProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPhotoUrl(productDto.getPhotoUrl());

        return _productRepository.setProduct(productEntity);
    }
}
