package com.pvanluom.springframeworkexercise.mapper;

import com.pvanluom.springframeworkexercise.model.Menu;
import com.pvanluom.springframeworkexercise.request.CreateMenuRequest;
import com.pvanluom.springframeworkexercise.request.UpdateMenuRequest;
import com.pvanluom.springframeworkexercise.response.MenuResponse;

import java.util.List;

public interface MenuMapper {
    MenuResponse parseToResponse(Menu menu);

    List<MenuResponse> parseToResponses(List<Menu> menus);

    Menu parseToMenu(CreateMenuRequest request);

    Menu parseToMenu(UpdateMenuRequest request);
}
