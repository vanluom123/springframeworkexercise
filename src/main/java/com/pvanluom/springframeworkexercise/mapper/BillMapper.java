package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Bill;
import com.pvanluom.springframeworkexercise.request.CreateBillRequest;
import com.pvanluom.springframeworkexercise.request.UpdateBillRequest;
import com.pvanluom.springframeworkexercise.response.BillResponse;

import java.util.List;

public interface BillMapper {
    BillResponse map(Bill bill);

    List<BillResponse> map(List<Bill> bills);

    Bill map(CreateBillRequest request);

    Bill map(UpdateBillRequest request);
}
