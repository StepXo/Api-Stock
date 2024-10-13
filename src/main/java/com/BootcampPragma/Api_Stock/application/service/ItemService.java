package com.BootcampPragma.Api_Stock.application.service;

import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.mapper.ItemRequest;
import com.BootcampPragma.Api_Stock.application.util.AppConstant;
import com.BootcampPragma.Api_Stock.application.util.PaginationUtil;
import com.BootcampPragma.Api_Stock.application.util.SorterUtil;
import com.BootcampPragma.Api_Stock.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryListSizeException;
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
        if (itemDto.getCategoryId() == null || itemDto.getCategoryId().isEmpty() || itemDto.getCategoryId().size() > AppConstant.THREE) {
            throw new CategoryListSizeException();
        }
        Item item = itemRequest.toItem(itemDto);
        itemServicePort.saveItem(item);
    }
    
    public ItemAuxDto getItem(String name){
        Item item = itemServicePort.getItem(name);
        return itemRequest.toItemDto(item);
    }
    public void checkStock(long id,long quantity){
        itemServicePort.checkStock(id,quantity);
    }

    public ItemAuxDto increaseStock(long articleId, int quantity){
        Item item = itemServicePort.increaseStock(articleId,quantity);
        return itemRequest.toItemDto(item);
    }

    public List<ItemAuxDto> getItemsByList(List<Long> itemIds){
        return itemIds.stream()
                .map(itemServicePort::getItem)
                .map(itemRequest::toItemDto)
                .toList();
    }

    public List<Integer> buy(List<ItemAuxDto> list) {
        return itemServicePort.buy(list.stream().map(itemRequest::toItem).toList());
    }
}
