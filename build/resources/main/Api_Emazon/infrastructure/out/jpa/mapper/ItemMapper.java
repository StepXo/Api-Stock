package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toItem(ItemEntity item);
    ItemEntity toItemEntity(Item item);
}
