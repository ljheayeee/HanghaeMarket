package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);
        Item saveItem = itemRepository.save(item);
        ItemResponseDto responseDto = new ItemResponseDto(saveItem);

        return responseDto;
    }

    public List<ItemResponseDto> getItems(){
        return itemRepository.findAllByOrderByTitleDesc().stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public Long updateItem(Long id, ItemRequestDto requestDto) {
        Item item = findItem(id);
        item.update(requestDto);

        return id;
    }

    public Long deleteItem(Long id) {
        Item item = findItem(id);
        itemRepository.delete(item);

        return id;
    }


    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 아이템은 존재하지 않습니다"));
    }

}
