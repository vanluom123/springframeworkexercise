package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Bill;
import com.pvanluom.springframeworkexercise.request.CreateBillRequest;
import com.pvanluom.springframeworkexercise.request.UpdateBillRequest;
import com.pvanluom.springframeworkexercise.response.BillResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapperImpl implements BillMapper {

    private final ModelMapper mapper;

    @Autowired
    public BillMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BillResponse map(Bill bill) {
        return mapper.map(bill, BillResponse.class);
    }

    @Override
    public List<BillResponse> map(List<Bill> bills) {
        return bills.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public Bill map(CreateBillRequest request) {
        return mapper.map(request, Bill.class);
    }

    @Override
    public Bill map(UpdateBillRequest request) {
        return mapper.map(request, Bill.class);
    }
}
