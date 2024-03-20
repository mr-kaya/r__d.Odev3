package org.mustafakaya.odev7.Service;

import org.mustafakaya.odev7.Core.Entity.OrderEntity;
import org.mustafakaya.odev7.Core.Entity.UserEntity;
import org.mustafakaya.odev7.Core.Services.ISmsService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements ISmsService {
    @Async
    @Override
    public void sendSmsOrderDetails(OrderEntity orderEntity, UserEntity userEntity) {
       String orderNumber = orderEntity.getOrderNumber();
       String name = userEntity.getName();
       String phoneNumber = userEntity.getPhoneNumber();

       String smsBody = "Merhaba "+name+", "+orderNumber+" numaralı siparişinizi aldık.";

       try {
           Thread.sleep(2000);
       }catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
}
