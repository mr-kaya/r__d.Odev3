package org.mustafakaya.odev4.API.Contoller;

import org.mustafakaya.odev4.Core.DTO.ProductDto;
import org.mustafakaya.odev4.Core.Services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final IProductService _productService;

    public ProductController(IProductService productService) {
        _productService = productService;
    }

    @GetMapping("/categoryFilter")
    public List<ProductDto> getProductsByCategory(@RequestParam String category) {
        return _productService.getProductsByCategory(category);
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts() {
        return _productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        Long getId = _productService.postProduct(productDto);

        return new ResponseEntity<>(" İşleminiz gerçekleştirilmiştir. "+getId+" numaralı ürün.", HttpStatus.CREATED);
    }
}