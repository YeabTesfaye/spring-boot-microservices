package com.yeab.orderservice.controller;


import com.yeab.orderservice.dto.OrderRequest;
import com.yeab.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @CircuitBreaker(name="inventory", fallbackMethod = "fallbackMethod")
//    @TimeLimiter(name="inventory ")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
       return orderService.placeOrder(orderRequest);
    }
    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException exception){
        return CompletableFuture.supplyAsync(() -> " OOps!!, Please order after some time  ");
    }
}
