package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ItemRequest {

    Item toItem(ItemDto article);
    ItemDto toItemDto(Item itemDto);

}
