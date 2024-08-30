package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.application.mapper.ItemRequest;
import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoryListSizeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRequest itemRequest;
    private  final ItemServicePort itemServicePort;


    public List<ItemAuxDto> getItemList() {
        return itemServicePort
                .getItemList()
                .stream()
                .map(itemRequest::toItemDto)
                .toList();
    }

    public void saveItem(ItemDto itemDto) {
        if (itemDto.getCategory_id() == null || itemDto.getCategory_id().isEmpty() || itemDto.getCategory_id().size() > 3) {
            throw new CategoryListSizeException();
        }
        Item item = itemRequest.toItem(itemDto);
        itemServicePort.saveItem(item);
    }
    
    public ItemAuxDto getItem(String name){
        Item item = itemServicePort.getItem(name);
        return itemRequest.toItemDto(item);
    }

}
