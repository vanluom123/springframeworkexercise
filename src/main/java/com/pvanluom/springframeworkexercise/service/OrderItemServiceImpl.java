package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.mapper.OrderMapper;
import com.pvanluom.springframeworkexercise.repository.BillRepository;
import com.pvanluom.springframeworkexercise.repository.ItemRepository;
import com.pvanluom.springframeworkexercise.repository.OrderedItemRepository;
import com.pvanluom.springframeworkexercise.request.CreateOrderItemRequest;
import com.pvanluom.springframeworkexercise.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderedItemRepository orderItemRepo;
    private final OrderMapper orderMapper;
    private final BillRepository billRepo;
    private final ItemRepository itemRepo;

    @Autowired
    public OrderItemServiceImpl(OrderedItemRepository orderItemRepo,
                                OrderMapper orderMapper,
                                BillRepository billRepo,
                                ItemRepository itemRepo) {
        this.orderItemRepo = orderItemRepo;
        this.orderMapper = orderMapper;
        this.billRepo = billRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public OrderResponse create(CreateOrderItemRequest request) {
        var order = orderMapper.map(request);
        var opt = billRepo.findById(request.getBillId());

        if (opt.isEmpty()) return null;

        var bill = opt.get();
        var item = itemRepo.findById(request.getItemId());

        if (item.isEmpty()) return null;

        int price = 0;
        price += item.get().getPrice() * item.get().getQuality();
        bill.setTotalPrice(price);

        bill = billRepo.save(bill);
        order = orderItemRepo.save(order);

        return orderMapper.map(order);
    }

    @Override
    public void deleteByItemId(String itemId) {
        orderItemRepo.deleteByItemId(itemId);
    }
}
