package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "Spring",uses = {CategoryRequest.class, BrandRequest.class})
public interface ItemRequest {
    @Mappings({
            @Mapping(target = "category", source = "category"),
            @Mapping(target = "brand", source = "brand")
    })
    ItemDto toItemDto(Item item);

    @Mappings({
            @Mapping(target = "category", source = "category"),
            @Mapping(target = "brand", source = "brand")
    })
    Item toItem(ItemDto itemDto);

}
