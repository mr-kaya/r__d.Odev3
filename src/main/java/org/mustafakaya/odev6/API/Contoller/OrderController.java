package org.mustafakaya.odev6.API.Contoller;

import org.mustafakaya.odev6.Core.DTO.OrderRequestDto;
import org.mustafakaya.odev6.Core.Services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final IOrderService _orderService;

    public OrderController(IOrderService orderService) {
        this._orderService = orderService;
    }


    /*
    * http://localhost:8989/order
    * {
    *   "productId":100,
    *   "orderDescription":""
    * }
    */
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        _orderService.saveOrder(orderRequestDto);

        return new ResponseEntity<>("Kayıt işlemi başarılı.", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestParam Long id) {
        _orderService.deleteOrderById(id);
        return new ResponseEntity<>("Kayıt başarı ile silindi.", HttpStatus.OK);
    }
}
