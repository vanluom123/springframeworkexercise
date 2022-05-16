package com.pvanluom.springframeworkexercise.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateOrderItemRequest {
    @NotBlank(message = "Id of bill is not blank")
    private String billId;
    @NotBlank(message = "Id of bill is not blank")
    private String itemId;
}
