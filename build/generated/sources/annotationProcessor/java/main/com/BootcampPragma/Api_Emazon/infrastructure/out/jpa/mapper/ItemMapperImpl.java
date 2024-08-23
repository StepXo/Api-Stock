package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-22T20:20:46-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toItem(ItemEntity item) {
        if ( item == null ) {
            return null;
        }

        Long quantity = null;
        double price = 0.0d;
        long id = 0L;
        String name = null;
        String description = null;
        Long id_category = null;
        Long id_brand = null;

        quantity = item.getQuantity();
        price = item.getPrice();
        id = item.getId();
        name = item.getName();
        description = item.getDescription();
        id_category = item.getId_category();
        id_brand = item.getId_brand();

        Item item1 = new Item( id, name, description, quantity, price, id_category, id_brand );

        return item1;
    }

    @Override
    public ItemEntity toItemEntity(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setId( item.getId() );
        itemEntity.setName( item.getName() );
        itemEntity.setDescription( item.getDescription() );
        if ( item.getQuantity() != null ) {
            itemEntity.setQuantity( item.getQuantity() );
        }
        itemEntity.setPrice( item.getPrice() );
        itemEntity.setId_category( item.getId_category() );
        itemEntity.setId_brand( item.getId_brand() );

        return itemEntity;
    }
}
