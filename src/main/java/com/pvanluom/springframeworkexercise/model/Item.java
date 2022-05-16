package com.pvanluom.springframeworkexercise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "menu_id", nullable = false)
    private String menuId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quality")
    private int quality;

    @Column(name = "price")
    private int price;

    @Column(name = "note")
    private String note;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @MapsId(value = "menuId")
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Set<OrderedItem> orderedItems = new HashSet<>();
}
