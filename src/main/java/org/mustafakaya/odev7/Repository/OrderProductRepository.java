package org.mustafakaya.odev7.Repository;

import org.mustafakaya.odev7.Core.Entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, Long> {

}
