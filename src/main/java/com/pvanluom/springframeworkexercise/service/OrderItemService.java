package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.request.CreateOrderItemRequest;
import com.pvanluom.springframeworkexercise.response.OrderResponse;

public interface OrderItemService {
    OrderResponse create(CreateOrderItemRequest request);
    void deleteByItemId(String itemId);
}
