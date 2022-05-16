package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.request.CreateBillRequest;
import com.pvanluom.springframeworkexercise.request.UpdateBillRequest;
import com.pvanluom.springframeworkexercise.response.BillResponse;

import java.util.List;

public interface BillService {
    BillResponse create(CreateBillRequest request);

    BillResponse update(UpdateBillRequest request);

    List<BillResponse> getBills();

    BillResponse getBillById(String id);

    void deleteById(String id);
}
