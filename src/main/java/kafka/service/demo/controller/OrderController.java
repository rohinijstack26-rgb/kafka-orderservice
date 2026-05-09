package kafka.service.demo.controller;

import kafka.service.demo.model.OrderEvent;
import kafka.service.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; 


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody OrderEvent event) {
        orderService.createOrder(event);
        
        return "Order event published successfully=>"+event.toString();
    }

}
