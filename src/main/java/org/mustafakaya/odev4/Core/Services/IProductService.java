package org.mustafakaya.odev4.Core.Services;

import org.mustafakaya.odev4.Core.DTO.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public interface IProductService {
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategory(String categoryName);
    Long postProduct(ProductDto productDto);
}
