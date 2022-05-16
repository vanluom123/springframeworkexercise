package com.pvanluom.springframeworkexercise.repository;

import com.pvanluom.springframeworkexercise.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    @Modifying
    @Query(value = "select count(item.id) from item\n" +
            "where item.id in (\n" +
            "\tselect ordered_item.item_id from ordered_item\n" +
            ")", nativeQuery = true)
    boolean existsById(String itemId);
}