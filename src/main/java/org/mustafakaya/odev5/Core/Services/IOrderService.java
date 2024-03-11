package org.mustafakaya.odev5.Core.Services;

import org.mustafakaya.odev5.Core.DTO.OrderRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    void saveOrder(OrderRequestDto orderRequestDto);
}

