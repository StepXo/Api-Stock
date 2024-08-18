package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T18:04:45-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ItemRequestImpl implements ItemRequest {

    @Override
    public Item toItem(ItemDto article) {
        if ( article == null ) {
            return null;
        }

        Long quantity = null;
        double price = 0.0d;
        long id = 0L;
        String name = null;
        String description = null;

        quantity = article.getQuantity();
        price = article.getPrice();
        id = article.getId();
        name = article.getName();
        description = article.getDescription();

        Item item = new Item( id, name, description, quantity, price );

        return item;
    }

    @Override
    public ItemDto toItemDto(Item itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        ItemDto itemDto1 = new ItemDto();

        itemDto1.setId( itemDto.getId() );
        itemDto1.setName( itemDto.getName() );
        itemDto1.setDescription( itemDto.getDescription() );
        if ( itemDto.getQuantity() != null ) {
            itemDto1.setQuantity( itemDto.getQuantity() );
        }
        itemDto1.setPrice( itemDto.getPrice() );

        return itemDto1;
    }
}
