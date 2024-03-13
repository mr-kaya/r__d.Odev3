package org.mustafakaya.odev6.Service;

import org.apache.coyote.BadRequestException;
import org.mustafakaya.odev6.Core.DTO.OrderRequestDto;
import org.mustafakaya.odev6.Core.Entity.OrderEntity;
import org.mustafakaya.odev6.Core.Entity.OrderProductEntity;
import org.mustafakaya.odev6.Core.Entity.ProductEntity;
import org.mustafakaya.odev6.Core.Services.IOrderService;
import org.mustafakaya.odev6.Repository.OrderProductRepository;
import org.mustafakaya.odev6.Repository.OrderRepository;
import org.mustafakaya.odev6.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository _orderRepository;
    private final ProductRepository _productRepository;
    private final OrderProductRepository _orderProductRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository) {
        _orderRepository = orderRepository;
        _productRepository = productRepository;
        _orderProductRepository = orderProductRepository;
    }


    @Override
    public void saveOrder(OrderRequestDto orderRequestDto) {
        long productId = orderRequestDto.getProductId();
        String orderDescription = orderRequestDto.getOrderDescription();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDescription(orderDescription);
        _orderRepository.save(orderEntity);

        ProductEntity productEntity = _productRepository.findById(productId).get();

        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderEntity(orderEntity);
        orderProductEntity.setProductEntity(productEntity);

        _orderProductRepository.save(orderProductEntity);

    }

    @Override
    public void deleteOrderById(Long id) {
        _orderProductRepository.deleteById(id);
        _orderRepository.deleteById(id);
    }
}