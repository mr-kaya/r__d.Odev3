package org.mustafakaya.odev5.Core.Services;

import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
    void postOrderWithProductId(Long id);
}

//oluşturduğunuz product ve order entitylerinde fetch stratejisini belirtiniz. order ve product için ortak bir
//entity oluşturup bu ilişkiyi kuracak bir api yazınız.
//Kullanıcı product apisi ile product oluştursun.
//Sonra order apisi üzerinden bu product ile ilişkili bir order oluşsun.  <------------ BURADA KALDIM!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
