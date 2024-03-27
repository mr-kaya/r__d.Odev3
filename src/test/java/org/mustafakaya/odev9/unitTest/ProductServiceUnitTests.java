package org.mustafakaya.odev9.unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mustafakaya.odev9.Core.DTO.ProductDto;
import org.mustafakaya.odev9.Core.Entity.ProductEntity;
import org.mustafakaya.odev9.Repository.ProductRepository;
import org.mustafakaya.odev9.Service.ProductService;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceUnitTests {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProduct_ValidId_Test() {
        long productId = 100;
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productId);
        productEntity.setCategory("Tulum");
        productEntity.setDescription("");
        productEntity.setName("Bergama Tulum");
        productEntity.setPrice(380.0);
        productEntity.setPhotoUrl("");
        productEntity.setCreateDate(new Date());
        productEntity.setUpdateDate(new Date());

        ProductDto productDtoExpected = new ProductDto();
        productDtoExpected.setName("Bergama Tulum");
        productDtoExpected.setPrice(380.0);
        productDtoExpected.setCategory("Tulum");
        productDtoExpected.setDescription("");
        productDtoExpected.setPhotoUrl("");

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(productEntity));
        ProductDto productDtoActual = productService.getProductWithId(productId);

        Assertions.assertEquals(productDtoExpected.getName(), productDtoActual.getName());
        Assertions.assertEquals(productDtoExpected.getPrice(), productDtoActual.getPrice());
        Assertions.assertEquals(productDtoExpected.getDescription(), productDtoActual.getDescription());
        Assertions.assertEquals(productDtoExpected.getCategory(), productDtoActual.getCategory());
        Assertions.assertEquals(productDtoExpected.getPhotoUrl(), productDtoActual.getPhotoUrl());
    }

    @Test
    public void getProduct_InvalidId_Test() {
        long productId = 999;

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> productService.getProductWithId(productId));
    }
}
