package com.pvanluom.springframeworkexercise.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {
    private String id;
    private String name;
    private String description;
    private int price;
    private int quality;
    private String note;
    private String type;
}
