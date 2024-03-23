package org.mustafakaya.odev8.Service;

import org.mustafakaya.odev8.Core.DTO.ProductDto;
import org.mustafakaya.odev8.Core.Entity.ProductEntity;
import org.mustafakaya.odev8.Core.Services.IProductService;
import org.mustafakaya.odev8.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository _productRepository;

    public ProductService(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return convertEntityToDtoList(_productRepository.findAll());
    }
    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {

        return convertEntityToDtoList(_productRepository.findByCategory(categoryName));
    }

    @Override
    public void postProduct(ProductDto productDto) {
        try {
            _productRepository.save(convertDtoToEntity(productDto));
        } catch (Exception e) {
            System.err.println("Unexpected error: "+e.getMessage());
            throw new RuntimeException("Ürün kaydedilirken hata oluştu.");
        }
    }

    @Override
    public List<ProductDto> convertEntityToDtoList(Iterable<ProductEntity> productEntities) {
        List<ProductDto> productDtos = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {
            ProductDto productDto = new ProductDto();
            productDto.setName(productEntity.getName());
            productDto.setDescription(productEntity.getDescription());
            productDto.setCategory(productEntity.getCategory());
            productDto.setPrice(productEntity.getPrice());
            productDto.setPhotoUrl(productEntity.getPhotoUrl());

            productDtos.add(productDto);
        }

        return productDtos;
    }

    @Override
    public ProductEntity convertDtoToEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(productDto.getCategory());
        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setPhotoUrl(productDto.getPhotoUrl());

        return productEntity;
    }

}
