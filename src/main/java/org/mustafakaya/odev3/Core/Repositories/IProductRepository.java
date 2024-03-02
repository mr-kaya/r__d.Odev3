package org.mustafakaya.odev3.Core.Repositories;

import org.mustafakaya.odev3.Core.Entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByCategory(String categoryName);
}
