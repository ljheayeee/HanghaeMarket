package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.service.ItemService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public Long updateItem(@PathVariable long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
