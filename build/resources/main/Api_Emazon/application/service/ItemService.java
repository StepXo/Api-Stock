package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.application.mapper.ItemRequest;
import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRequest itemRequest;
    private  final ItemServicePort itemServicePort;

    public List<ItemDto> getItemList() {
        return itemServicePort
                .getItemList()
                .stream()
                .map(itemRequest::toItemDto)
                .collect(Collectors.toList()
                );
    }

    public void saveItem(ItemDto ItemDto){
        Item item = itemRequest.toItem(ItemDto);
        itemServicePort.saveItem(item);
    }

}
