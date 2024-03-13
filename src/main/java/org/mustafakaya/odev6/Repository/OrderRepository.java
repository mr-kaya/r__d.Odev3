package org.mustafakaya.odev6.Repository;


import org.mustafakaya.odev6.Core.Entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
