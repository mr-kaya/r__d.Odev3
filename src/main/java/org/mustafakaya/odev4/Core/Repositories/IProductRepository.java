package org.mustafakaya.odev4.Core.Repositories;

import org.mustafakaya.odev4.Core.Entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByCategory(String categoryName);
    Long setProduct(ProductEntity productEntity);
}
