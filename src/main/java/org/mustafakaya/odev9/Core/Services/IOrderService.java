package org.mustafakaya.odev9.Core.Services;

import org.mustafakaya.odev9.Core.DTO.OrderRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    void saveOrder(OrderRequestDto orderRequestDto);
    void deleteOrderById(Long id);
}

