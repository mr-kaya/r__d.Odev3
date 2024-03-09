package org.mustafakaya.odev5.Service;

import org.mustafakaya.odev5.Core.Entity.OrderEntity;
import org.mustafakaya.odev5.Core.Entity.OrderProductEntity;
import org.mustafakaya.odev5.Core.Entity.ProductEntity;
import org.mustafakaya.odev5.Core.Services.IOrderService;
import org.mustafakaya.odev5.Repository.OrderRepository;
import org.mustafakaya.odev5.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository _orderRepository;
    private final ProductRepository _productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        _orderRepository = orderRepository;
        _productRepository = productRepository;
    }

    @Override
    public void postOrderWithProductId(Long id) {
        Random random = new Random();

       ProductEntity productEntity = _productRepository.findById(id).get();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(String.valueOf(random.nextInt(999999999 - 100000000) + 100000000));
        orderEntity.setOrderDescription(productEntity.getDescription());
        orderEntity.setTotalAmount(productEntity.getPrice());

       _orderRepository.save(orderEntity);
    }
}
