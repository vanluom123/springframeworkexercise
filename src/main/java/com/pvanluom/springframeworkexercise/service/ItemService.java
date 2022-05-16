package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.request.CreateItemRequest;
import com.pvanluom.springframeworkexercise.request.UpdateItemRequest;
import com.pvanluom.springframeworkexercise.response.ItemResponse;

import java.util.List;

public interface ItemService {
    ItemResponse create(CreateItemRequest request);
    ItemResponse update(UpdateItemRequest request);
    void deleteById(String id);
    List<ItemResponse> getItems();
    ItemResponse getItemById(String id);
}
