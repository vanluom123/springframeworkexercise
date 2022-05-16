package com.pvanluom.springframeworkexercise.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class MenuResponse {
    private String id;
    private String type;
    private List<ItemResponse> itemResponses;
}
