package com.pvanluom.springframeworkexercise.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateItemRequest {
    private String id;
    @NotBlank(message = "menu id is not blank")
    private String menuId;
    private String name;
    private String description;
    private String note;
    private int price;
    private int quality;
    @NotBlank(message = "type is not blank")
    private String type;
}
