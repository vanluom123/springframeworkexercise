package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Item;
import com.pvanluom.springframeworkexercise.request.CreateItemRequest;
import com.pvanluom.springframeworkexercise.request.UpdateItemRequest;
import com.pvanluom.springframeworkexercise.response.ItemResponse;

import java.util.Collection;
import java.util.List;

public interface ItemMapper {
    ItemResponse map(Item item);
    List<ItemResponse> map(Collection<Item> items);
    Item map(CreateItemRequest request);
    Item map(UpdateItemRequest request);
}
