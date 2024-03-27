package org.mustafakaya.odev9.Core.Services;

import org.mustafakaya.odev9.Core.Entity.OrderEntity;
import org.mustafakaya.odev9.Core.Entity.UserEntity;
import org.springframework.scheduling.annotation.Async;

public interface ISmsService {
    @Async
    void sendSmsOrderDetails(OrderEntity orderEntity, UserEntity userEntity);
}
