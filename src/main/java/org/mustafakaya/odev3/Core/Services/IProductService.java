package org.mustafakaya.odev3.Core.Services;

import org.mustafakaya.odev3.Core.DTO.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategory(String categoryName);
}
