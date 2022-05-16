package com.pvanluom.springframeworkexercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private Set<Item> menuItems = new HashSet<>();
}
