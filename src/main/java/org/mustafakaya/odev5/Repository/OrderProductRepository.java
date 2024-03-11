package org.mustafakaya.odev5.Repository;

import org.mustafakaya.odev5.Core.Entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, Long> {

}
