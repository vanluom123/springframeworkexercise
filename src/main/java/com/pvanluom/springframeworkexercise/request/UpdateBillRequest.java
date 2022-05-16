package com.pvanluom.springframeworkexercise.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateBillRequest {
    private String id;
    private Date orderedTime;
    private int totalPrice;
}
