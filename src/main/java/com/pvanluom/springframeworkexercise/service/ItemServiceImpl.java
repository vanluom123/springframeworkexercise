package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.mapper.ItemMapper;
import com.pvanluom.springframeworkexercise.repository.ItemRepository;
import com.pvanluom.springframeworkexercise.request.CreateItemRequest;
import com.pvanluom.springframeworkexercise.request.UpdateItemRequest;
import com.pvanluom.springframeworkexercise.response.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepo;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepo,
                           ItemMapper itemMapper) {
        this.itemRepo = itemRepo;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemResponse create(CreateItemRequest request) {
        var model = itemMapper.map(request);
        if (model.getId() == null) {
            model.setId(UUID.randomUUID().toString());
        }
        model = itemRepo.save(model);
        return itemMapper.map(model);
    }

    @Transactional
    @Override
    public ItemResponse update(UpdateItemRequest request) {
        var opt = itemRepo.findById(request.getId());
        if (opt.isEmpty())
            return null;
        var item = itemMapper.map(request);
        item = itemRepo.save(item);
        return itemMapper.map(item);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<ItemResponse> getItems() {
        var items = itemRepo.findAll();
        return itemMapper.map(items);
    }

    @Override
    public ItemResponse getItemById(String id) {
        var model = itemRepo.findById(id);
        if (model.isEmpty())
            return null;
        var item = model.get();
        return itemMapper.map(item);
    }
}
