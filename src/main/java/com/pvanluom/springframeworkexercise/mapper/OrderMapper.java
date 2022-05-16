package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.OrderedItem;
import com.pvanluom.springframeworkexercise.request.CreateOrderItemRequest;
import com.pvanluom.springframeworkexercise.response.OrderResponse;

import java.util.Collection;
import java.util.List;

public interface OrderMapper {
    OrderedItem map(CreateOrderItemRequest request);
    OrderResponse map(OrderedItem model);
    List<OrderResponse> map(Collection<OrderedItem> orderedItems);
}
