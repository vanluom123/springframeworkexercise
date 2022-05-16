package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.request.CreateMenuRequest;
import com.pvanluom.springframeworkexercise.request.UpdateMenuRequest;
import com.pvanluom.springframeworkexercise.response.MenuPaginationResponse;
import com.pvanluom.springframeworkexercise.response.MenuResponse;

import java.util.List;

public interface MenuService {
    MenuResponse create(CreateMenuRequest request);

    MenuPaginationResponse getMenuPanigation(int pageNo, int pageSize, String sortBy, String sortDir);

    MenuResponse getDetail(String id);

    List<MenuResponse> getAll();

    MenuResponse update(UpdateMenuRequest request);

    void delete(String id);

    List<MenuResponse> searchByDescription(String description);

    List<MenuResponse> searchByName(String name);
}
