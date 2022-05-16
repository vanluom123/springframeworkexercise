package com.pvanluom.springframeworkexercise.controller;

import com.pvanluom.springframeworkexercise.request.CreateOrderItemRequest;
import com.pvanluom.springframeworkexercise.response.OrderResponse;
import com.pvanluom.springframeworkexercise.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @DeleteMapping("/deleteByItemId/{id}")
    public void deleteByItemId(@Valid @PathVariable String id) {
        orderItemService.deleteByItemId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderItemRequest request) {
        var response = orderItemService.create(request);
        if(response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
