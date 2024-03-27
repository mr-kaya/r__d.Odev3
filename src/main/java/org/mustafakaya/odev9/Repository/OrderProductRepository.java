package org.mustafakaya.odev9.Repository;

import org.mustafakaya.odev9.Core.Entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, Long> {

}
