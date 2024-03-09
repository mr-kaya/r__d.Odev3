package org.mustafakaya.odev5.API.Contoller;

import org.mustafakaya.odev5.Core.DTO.ProductOrderDto;
import org.mustafakaya.odev5.Core.Services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final IOrderService _orderService;

    public OrderController(IOrderService orderService) {
        this._orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestParam Long product) {
        _orderService.postOrderWithProductId(product);

        return new ResponseEntity<>("Kayıt işlemi başarılı.", HttpStatus.CREATED);
    }
}
