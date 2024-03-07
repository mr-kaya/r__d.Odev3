package org.mustafakaya.odev4.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.mustafakaya.odev4.Core.Entity.ProductEntity;
import org.mustafakaya.odev4.Core.Repositories.IProductRepository;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductEntity> getAllProducts() {
        return null;
    }

    @Override
    public List<ProductEntity> getProductsByCategory(String categoryName) {
        return null;
    }

    @Override
    @Transactional
    public Long setProduct(ProductEntity productEntity) {
        entityManager.persist(productEntity);
        entityManager.flush();
        entityManager.clear();
        return productEntity.getId();
    }
}
