package org.mustafakaya.odev5.Core.Services;

import org.mustafakaya.odev5.Core.DTO.ProductDto;
import org.mustafakaya.odev5.Core.Entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategory(String categoryName);
    void postProduct(ProductDto productDto);
    List<ProductDto> convertEntityToDtoList(Iterable<ProductEntity> productEntities);
    ProductEntity convertDtoToEntity(ProductDto productDto);
}
