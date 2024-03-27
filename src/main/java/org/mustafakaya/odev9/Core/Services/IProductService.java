package org.mustafakaya.odev9.Core.Services;

import org.mustafakaya.odev9.Core.DTO.ProductDto;
import org.mustafakaya.odev9.Core.Entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductWithId(long id);
    List<ProductDto> getProductsByCategory(String categoryName);
    void postProduct(ProductDto productDto);
    List<ProductDto> convertEntityToDtoList(Iterable<ProductEntity> productEntities);
    ProductEntity convertDtoToEntity(ProductDto productDto);
    ProductDto convertEntityToDto(Optional<ProductEntity> productEntity);
}
