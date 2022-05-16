package com.pvanluom.springframeworkexercise.controller;

import com.pvanluom.springframeworkexercise.constants.AppConstants;
import com.pvanluom.springframeworkexercise.request.CreateMenuRequest;
import com.pvanluom.springframeworkexercise.request.UpdateMenuRequest;
import com.pvanluom.springframeworkexercise.response.MenuPaginationResponse;
import com.pvanluom.springframeworkexercise.response.MenuResponse;
import com.pvanluom.springframeworkexercise.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/create")
    public ResponseEntity<MenuResponse> create(@Valid @RequestBody CreateMenuRequest request) {
        var response = menuService.create(request);
        if (response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getMenuPagination")
    public MenuPaginationResponse getMenuPagination(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return menuService.getMenuPanigation(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/getDetail/{id}")
    public ResponseEntity<MenuResponse> getDetail(@Valid @PathVariable String id) {
        var response = menuService.getDetail(id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuResponse>> getAll() {
        var responses = menuService.getAll();
        if (responses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MenuResponse> update(@Valid @RequestBody UpdateMenuRequest request) {
        var response = menuService.update(request);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMenuById(@Valid @PathVariable String id) {
        menuService.delete(id);
    }

    @GetMapping("/searchMenuByName/{name}")
    public ResponseEntity<List<MenuResponse>> searchMenuByName(@Valid @PathVariable String name) {
        var responses = menuService.searchByName(name);
        if (responses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/searchMenuByDescription/{description}")
    public ResponseEntity<List<MenuResponse>> searchMenuByDescription(@Valid @PathVariable String description) {
        var responses = menuService.searchByDescription(description);
        if (responses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
