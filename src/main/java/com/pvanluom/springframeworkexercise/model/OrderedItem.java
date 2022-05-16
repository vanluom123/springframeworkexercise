package com.pvanluom.springframeworkexercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ordered_item")
@Setter
@Getter
public class OrderedItem {
    @EmbeddedId
    private OrderedItemKey key;

    @ManyToOne
    @MapsId(value = "billId")
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @MapsId(value = "itemId")
    @JoinColumn(name = "item_id")
    private Item item;
}
