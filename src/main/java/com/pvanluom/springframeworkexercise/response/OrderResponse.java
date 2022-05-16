package com.pvanluom.springframeworkexercise.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private String billId;
    private String itemId;
    private BillResponse billResponse;
    private ItemResponse itemResponse;
}
