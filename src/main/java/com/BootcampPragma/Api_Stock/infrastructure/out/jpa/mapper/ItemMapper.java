package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.ItemEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = InfraConstants.SPRING, uses = {CategoryMapper.class, BrandMapper.class})
public interface ItemMapper {
    Item toItem(ItemEntity item);
    ItemEntity toItemEntity(Item item);
}
