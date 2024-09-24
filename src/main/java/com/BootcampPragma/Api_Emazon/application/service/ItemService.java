package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Emazon.application.mapper.ItemRequest;
import com.BootcampPragma.Api_Emazon.application.util.PaginationUtil;
import com.BootcampPragma.Api_Emazon.application.util.SorterUtil;
import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoryListSizeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRequest itemRequest;
    private  final ItemServicePort itemServicePort;
    private final SorterUtil sorterUtil;
    private final PaginationUtil paginationUtil;

    public List<ItemAuxDto> getItemList() {
        return itemServicePort
                .getItemList()
                .stream()
                .map(itemRequest::toItemDto)
                .toList();
    }

    public Page<ItemAuxDto> getItemsOrdered(String order, int page, int size) {

        List<ItemAuxDto> itemAuxDto = itemServicePort
                .getItemList()
                .stream()
                .map(itemRequest::toItemDto)
                .toList();

        List<ItemAuxDto> sortedItemDto = sorterUtil.getSortedItems(order,itemAuxDto);
        return paginationUtil.getItemsPagination(order, page, size, sortedItemDto);
    }

    public Page<ItemAuxDto> getItemsOrdered(String order,String variable, int page, int size) {

        List<ItemAuxDto> itemAuxDto = itemServicePort
                .getItemList()
                .stream()
                .map(itemRequest::toItemDto)
                .toList();

        List<ItemAuxDto> sortedItemDto = sorterUtil.getSortedItems(order,variable, itemAuxDto);
        return paginationUtil.getItemsPagination(order, page, size, sortedItemDto);
    }
    

    public void saveItem(ItemDto itemDto) {
        if (itemDto.getCategoryId() == null || itemDto.getCategoryId().isEmpty() || itemDto.getCategoryId().size() > 3) {
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
