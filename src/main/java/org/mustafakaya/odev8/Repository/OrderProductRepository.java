package org.mustafakaya.odev8.Repository;

import org.mustafakaya.odev8.Core.Entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, Long> {

}
