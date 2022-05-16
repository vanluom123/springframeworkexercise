package com.pvanluom.springframeworkexercise.controller;

import com.pvanluom.springframeworkexercise.request.CreateBillRequest;
import com.pvanluom.springframeworkexercise.request.UpdateBillRequest;
import com.pvanluom.springframeworkexercise.response.BillResponse;
import com.pvanluom.springframeworkexercise.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/createBill")
    public ResponseEntity<BillResponse> createBill(@RequestBody CreateBillRequest request) {
        var response = billService.create(request);
        if (response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateBill")
    public ResponseEntity<BillResponse> updateBill(@RequestBody UpdateBillRequest request) {
        var response = billService.update(request);
        if (response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void delete(@Valid @PathVariable String id) {
        billService.deleteById(id);
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<BillResponse>> getAll() {
        var responses = billService.getBills();
        if (responses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
