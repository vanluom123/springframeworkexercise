package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Menu;
import com.pvanluom.springframeworkexercise.request.CreateMenuRequest;
import com.pvanluom.springframeworkexercise.request.UpdateMenuRequest;
import com.pvanluom.springframeworkexercise.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuMapperImpl implements MenuMapper {
    private final ItemMapper itemMapper;

    @Autowired
    public MenuMapperImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public MenuResponse parseToResponse(Menu menu) {
        var menuResponseBuilder = MenuResponse.builder()
                .type(menu.getType())
                .id(menu.getId());
        var items = menu.getMenuItems();
        var itemResponse = itemMapper.map(items);
        menuResponseBuilder.itemResponses(itemResponse);
        return menuResponseBuilder.build();
    }

    @Override
    public List<MenuResponse> parseToResponses(List<Menu> menus) {
        List<MenuResponse> responses = new ArrayList<>();
        menus.forEach(menu -> {
            var response = parseToResponse(menu);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public Menu parseToMenu(CreateMenuRequest request) {
        Menu menu = new Menu();
        menu.setType(request.getType());
        return menu;
    }

    @Override
    public Menu parseToMenu(UpdateMenuRequest request) {
        Menu menu = new Menu();
        menu.setId(request.getId());
        menu.setType(request.getType());
        return menu;
    }
}
