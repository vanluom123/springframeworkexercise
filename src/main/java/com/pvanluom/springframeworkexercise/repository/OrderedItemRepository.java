package com.pvanluom.springframeworkexercise.repository;

import com.pvanluom.springframeworkexercise.model.OrderedItem;
import com.pvanluom.springframeworkexercise.model.OrderedItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, OrderedItemKey> {

    @Transactional
    @Modifying
    @Query(value = "delete from ordered_item where ordered_item.item_id = ?1", nativeQuery = true)
    void deleteByItemId(String itemId);
}