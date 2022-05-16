package com.pvanluom.springframeworkexercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class OrderedItemKey implements Serializable {
    @Column(name = "bill_id")
    private String billId;

    @Column(name = "item_id")
    private String itemId;
}
