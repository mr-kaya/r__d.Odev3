package org.mustafakaya.odev5.Repository;


import org.mustafakaya.odev5.Core.Entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
