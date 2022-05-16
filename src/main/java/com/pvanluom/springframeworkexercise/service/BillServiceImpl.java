package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.mapper.BillMapper;
import com.pvanluom.springframeworkexercise.repository.BillRepository;
import com.pvanluom.springframeworkexercise.request.CreateBillRequest;
import com.pvanluom.springframeworkexercise.request.UpdateBillRequest;
import com.pvanluom.springframeworkexercise.response.BillResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepo;
    private final BillMapper billMapper;

    @Autowired
    public BillServiceImpl(BillRepository billRepo, BillMapper billMapper) {
        this.billRepo = billRepo;
        this.billMapper = billMapper;
    }

    @Override
    public BillResponse create(CreateBillRequest request) {
        var bill = billMapper.map(request);
        if(bill.getId() == null)
            bill.setId(UUID.randomUUID().toString());
        bill = billRepo.save(bill);
        return billMapper.map(bill);
    }

    @Transactional
    @Override
    public BillResponse update(UpdateBillRequest request) {
        var opt = billRepo.findById(request.getId());
        if(opt.isEmpty())
            return null;
        var bill = billMapper.map(request);
        bill = billRepo.save(bill);
        return billMapper.map(bill);
    }

    @Override
    public List<BillResponse> getBills() {
        var bills = billRepo.findAll();
        return billMapper.map(bills);
    }

    @Override
    public BillResponse getBillById(String id) {
        var opt = billRepo.findById(id);
        if(opt.isEmpty()) return null;
        var bill = opt.get();
        return billMapper.map(bill);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        billRepo.deleteById(id);
    }
}
