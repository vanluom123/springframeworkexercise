package com.pvanluom.springframeworkexercise.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "bill")
@Getter
@Setter
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "orderedTime")
    private Date orderedTime;

    @Column(name = "totalPrice")
    private int totalPrice;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
    private Set<OrderedItem> orderedItems = new HashSet<>();

}
