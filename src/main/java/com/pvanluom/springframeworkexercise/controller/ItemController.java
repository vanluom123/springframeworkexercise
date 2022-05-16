package com.pvanluom.springframeworkexercise.controller;

import com.pvanluom.springframeworkexercise.request.CreateItemRequest;
import com.pvanluom.springframeworkexercise.request.UpdateItemRequest;
import com.pvanluom.springframeworkexercise.response.ItemResponse;
import com.pvanluom.springframeworkexercise.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemResponse> create(@Valid @RequestBody CreateItemRequest request) {
        var response = itemService.create(request);
        if(response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemResponse> update(@RequestBody UpdateItemRequest request) {
        var response = itemService.update(request);
        if(response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getItem/{id}")
    public ResponseEntity<ItemResponse> getItemById(@Valid @PathVariable String id) {
        var response = itemService.getItemById(id);
        if(response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getItems")
    public ResponseEntity<List<ItemResponse>> getItems() {
        var responses = itemService.getItems();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@Valid @PathVariable String id) {
        itemService.deleteById(id);
    }
}
