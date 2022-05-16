package com.pvanluom.springframeworkexercise.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BillResponse {
    private String id;
    private Date orderedTime;
    private int totalPrice;
}
