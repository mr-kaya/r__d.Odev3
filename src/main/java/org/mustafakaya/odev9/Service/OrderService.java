package org.mustafakaya.odev9.Service;

import jakarta.persistence.EntityNotFoundException;
import org.mustafakaya.odev9.Core.DTO.OrderRequestDto;
import org.mustafakaya.odev9.Core.Entity.OrderEntity;
import org.mustafakaya.odev9.Core.Entity.OrderProductEntity;
import org.mustafakaya.odev9.Core.Entity.ProductEntity;
import org.mustafakaya.odev9.Core.Entity.UserEntity;
import org.mustafakaya.odev9.Core.Services.IOrderService;
import org.mustafakaya.odev9.Repository.OrderProductRepository;
import org.mustafakaya.odev9.Repository.OrderRepository;
import org.mustafakaya.odev9.Repository.ProductRepository;
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

        try {
            Optional<UserEntity> userById = _userService.findUserById(userId);
            UserEntity userEntity = userById.get();
            orderEntity.setUserEntity(userEntity);
            _smsService.sendSmsOrderDetails(orderEntity, userEntity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Not found User: " + e.getMessage() + "\n UserId: " + orderRequestDto.getUserId());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: "+e.getMessage()+"\n UserId: "+orderRequestDto.getUserId());
        }
        _orderRepository.save(orderEntity);

        OrderProductEntity orderProductEntity = new OrderProductEntity();
        try {
            ProductEntity productEntity = _productRepository.findById(productId).get();
            orderProductEntity.setOrderEntity(orderEntity);
            orderProductEntity.setProductEntity(productEntity);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Not found Product: "+e.getMessage()+"\n productId: "+orderRequestDto.getProductId());
        }catch (Exception e) {
            throw new RuntimeException("Unexpected error: "+e.getMessage()+"\n productId: "+orderRequestDto.getProductId());
        }
        _orderProductRepository.save(orderProductEntity);
    }

    @Override
    public void deleteOrderById(Long id) {
        _orderProductRepository.deleteById(id);
        _orderRepository.deleteById(id);
    }
}
