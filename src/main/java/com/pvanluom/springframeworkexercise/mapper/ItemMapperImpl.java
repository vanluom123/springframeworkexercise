package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Item;
import com.pvanluom.springframeworkexercise.request.CreateItemRequest;
import com.pvanluom.springframeworkexercise.request.UpdateItemRequest;
import com.pvanluom.springframeworkexercise.response.ItemResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapperImpl implements ItemMapper {

    private final ModelMapper mapper;

    @Autowired
    public ItemMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ItemResponse map(Item item) {
        return mapper.map(item, ItemResponse.class);
    }

    @Override
    public List<ItemResponse> map(Collection<Item> items) {
        return items.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public Item map(CreateItemRequest request) {
        return mapper.map(request, Item.class);
    }

    @Override
    public Item map(UpdateItemRequest request) {
        return mapper.map(request, Item.class);
    }
}
