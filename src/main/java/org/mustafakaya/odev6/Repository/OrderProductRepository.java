package org.mustafakaya.odev6.Repository;

import org.mustafakaya.odev6.Core.Entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, Long> {

}
