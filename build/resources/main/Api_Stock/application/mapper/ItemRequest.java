package com.BootcampPragma.Api_Stock.application.mapper;

import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ItemRequest {

    Item toItem(ItemDto article);
    ItemDto toItemDto(Item itemDto);

}
