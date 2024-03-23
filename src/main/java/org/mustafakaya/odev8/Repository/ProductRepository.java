package org.mustafakaya.odev8.Repository;

import org.mustafakaya.odev8.Core.Entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category = ?1")
    List<ProductEntity> findByCategory(String category);
}
