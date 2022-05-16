package com.pvanluom.springframeworkexercise.repository;

import com.pvanluom.springframeworkexercise.model.Menu;
import com.pvanluom.springframeworkexercise.response.MenuResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
    @Query(value = "select menu.id, menu.type, item.name, item.description, item.price, item.type" +
            " from menu" +
            " join item on menu.id = item.menu_id" +
            " where item.description like concat('%', ?1, '%')",
    nativeQuery = true)
    List<Menu> searchMenuByDescription(String description);

    @Query(value = "select menu.id, menu.type, item.name, item.description, item.price, item.type" +
            " from menu" +
            " join item on menu.id = item.menu_id" +
            " where item.name like concat('%', ?1, '%')",
    nativeQuery = true)
    List<Menu> searchMenuByName(String name);

}