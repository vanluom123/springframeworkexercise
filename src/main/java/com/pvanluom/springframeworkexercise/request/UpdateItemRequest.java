package com.pvanluom.springframeworkexercise.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateItemRequest {
    @NotBlank(message = "Id is not blank")
    private String id;
    private String name;
    private String description;
    private int price;
    private String note;
    @NotBlank(message = "Type is not blank")
    private String type;
}
