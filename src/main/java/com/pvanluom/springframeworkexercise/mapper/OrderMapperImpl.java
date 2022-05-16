package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Bill;
import com.pvanluom.springframeworkexercise.model.Item;
import com.pvanluom.springframeworkexercise.model.OrderedItem;
import com.pvanluom.springframeworkexercise.request.CreateOrderItemRequest;
import com.pvanluom.springframeworkexercise.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {

    private final ModelMapper mapper;

    @Autowired
    public OrderMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public OrderedItem map(CreateOrderItemRequest request) {
        mapper.typeMap(CreateOrderItemRequest.class, OrderedItem.class)
                .addMappings(m -> {
                    m.map(CreateOrderItemRequest::getBillId, ((orderedItem, o) -> orderedItem.getKey().setBillId((String) o)));
                    m.map(CreateOrderItemRequest::getItemId, ((orderedItem, o) -> orderedItem.getKey().setItemId((String) o)));
                });
        return mapper.map(request, OrderedItem.class);
    }

    @Override
    public OrderResponse map(OrderedItem model) {
        mapper.typeMap(OrderedItem.class, OrderResponse.class)
                .addMappings(m -> {
                    m.map(orderedItem -> orderedItem.getKey().getBillId(), (orderResponse, o) -> orderResponse.setBillId((String) o));
                    m.map(orderedItem -> orderedItem.getKey().getItemId(), (orderResponse, o) -> orderResponse.setItemId((String) o));
                });
        return mapper.map(model, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> map(Collection<OrderedItem> orderedItems) {
        return orderedItems.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
