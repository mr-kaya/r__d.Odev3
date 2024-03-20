package org.mustafakaya.odev7.Service;

import org.mustafakaya.odev7.Core.DTO.OrderRequestDto;
import org.mustafakaya.odev7.Core.Entity.OrderEntity;
import org.mustafakaya.odev7.Core.Entity.OrderProductEntity;
import org.mustafakaya.odev7.Core.Entity.ProductEntity;
import org.mustafakaya.odev7.Core.Entity.UserEntity;
import org.mustafakaya.odev7.Core.Services.IOrderService;
import org.mustafakaya.odev7.Repository.OrderProductRepository;
import org.mustafakaya.odev7.Repository.OrderRepository;
import org.mustafakaya.odev7.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository _orderRepository;
    private final ProductRepository _productRepository;
    private final OrderProductRepository _orderProductRepository;
    private final UserService _userService;
    private final SmsService _smsService;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository, UserService userService, SmsService smsService) {
        _orderRepository = orderRepository;
        _productRepository = productRepository;
        _orderProductRepository = orderProductRepository;
        _userService = userService;
        _smsService = smsService;
    }


    @Override
    public void saveOrder(OrderRequestDto orderRequestDto) {
        long productId = orderRequestDto.getProductId();
        String orderDescription = orderRequestDto.getOrderDescription();
        Long userId = orderRequestDto.getUserId();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDescription(orderDescription);
        orderEntity.setOrderNumber(UUID.randomUUID().toString());
        Optional<UserEntity> userById = _userService.findUserById(userId);
        UserEntity userEntity = userById.get();
        orderEntity.setUserEntity(userEntity);

        _orderRepository.save(orderEntity);

        ProductEntity productEntity = _productRepository.findById(productId).get();

        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrderEntity(orderEntity);
        orderProductEntity.setProductEntity(productEntity);

        _orderProductRepository.save(orderProductEntity);

        _smsService.sendSmsOrderDetails(orderEntity, userEntity);
    }

    @Override
    public void deleteOrderById(Long id) {
        _orderProductRepository.deleteById(id);
        _orderRepository.deleteById(id);
    }
}
