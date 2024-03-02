package org.mustafakaya.odev3.API.Contoller;

import org.mustafakaya.odev3.Core.DTO.ProductDto;
import org.mustafakaya.odev3.Core.Services.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    private final IProductService _productService;

    public ProductController(IProductService productService) {
        _productService = productService;
    }

    @GetMapping("/categoryFilter")
    public List<ProductDto> getProductsByCategory(@RequestParam String category) {
        return _productService.getProductsByCategory(category);
    }

    @GetMapping("/allProducts")
    public List<ProductDto> getAllProducts() {
        return _productService.getAllProducts();
    }
}
