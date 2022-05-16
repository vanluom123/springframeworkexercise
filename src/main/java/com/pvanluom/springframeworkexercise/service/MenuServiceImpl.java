package com.pvanluom.springframeworkexercise.service;

import com.pvanluom.springframeworkexercise.mapper.MenuMapper;
import com.pvanluom.springframeworkexercise.model.Item;
import com.pvanluom.springframeworkexercise.model.Menu;
import com.pvanluom.springframeworkexercise.repository.MenuRepository;
import com.pvanluom.springframeworkexercise.request.CreateMenuRequest;
import com.pvanluom.springframeworkexercise.request.UpdateMenuRequest;
import com.pvanluom.springframeworkexercise.response.MenuPaginationResponse;
import com.pvanluom.springframeworkexercise.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepo;
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepo, MenuMapper menuMapper) {
        this.menuRepo = menuRepo;
        this.menuMapper = menuMapper;
    }

    @Override
    public MenuResponse create(CreateMenuRequest request) {
        var model = menuMapper.parseToMenu(request);
        if (model.getId() == null) {
            model.setId(UUID.randomUUID().toString());
        }
        model = menuRepo.save(model);
        return menuMapper.parseToResponse(model);
    }

    @Override
    public MenuPaginationResponse getMenuPanigation(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Menu> menuPage = menuRepo.findAll(pageable);

        // get content for page object
        List<Menu> listOfMenus = menuPage.getContent();

        List<MenuResponse> content = listOfMenus
                .stream()
                .map(menuMapper::parseToResponse)
                .collect(Collectors.toList());

        return MenuPaginationResponse.builder()
                .contents(content)
                .pageNo(menuPage.getNumber())
                .pageSize(menuPage.getSize())
                .totalElements(menuPage.getTotalElements())
                .totalPages(menuPage.getTotalPages())
                .last(menuPage.isLast())
                .build();
    }

    @Override
    public MenuResponse getDetail(String id) {
        var opt = menuRepo.findById(id);
        if (opt.isEmpty())
            return null;
        var item = opt.get();
        return menuMapper.parseToResponse(item);
    }

    @Override
    public List<MenuResponse> getAll() {
        var menus = menuRepo.findAll();
        return menuMapper.parseToResponses(menus);
    }

    @Transactional
    @Override
    public MenuResponse update(UpdateMenuRequest request) {
        var menu = menuRepo.findById(request.getId());
        if (menu.isEmpty())
            return null;
        var model = menuMapper.parseToMenu(request);
        model = menuRepo.save(model);
        return menuMapper.parseToResponse(model);
    }

    @Transactional
    @Override
    public void delete(String id) {
        menuRepo.deleteById(id);
    }

    @Override
    public List<MenuResponse> searchByDescription(String description) {
        var menus = menuRepo.searchMenuByDescription(description);
        return menuMapper.parseToResponses(menus);
    }

    @Override
    public List<MenuResponse> searchByName(String name) {
        var menus = menuRepo.searchMenuByName(name);
        return menuMapper.parseToResponses(menus);
    }
}
