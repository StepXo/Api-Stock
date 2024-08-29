package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T22:07:42-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ItemRequestImpl implements ItemRequest {

    @Autowired
    private CategoryRequest categoryRequest;
    @Autowired
    private BrandRequest brandRequest;

    @Override
    public ItemDto toItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setCategory( categoryListToCategoryDtoList( item.getCategory() ) );
        itemDto.setBrand( brandRequest.toBrandDto( item.getBrand() ) );
        itemDto.setId( item.getId() );
        itemDto.setName( item.getName() );
        itemDto.setDescription( item.getDescription() );
        itemDto.setQuantity( item.getQuantity() );
        itemDto.setPrice( item.getPrice() );

        return itemDto;
    }

    @Override
    public Item toItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        List<Category> category = null;
        Brand brand = null;
        long quantity = 0L;
        double price = 0.0d;
        long id = 0L;
        String name = null;
        String description = null;

        category = categoryDtoListToCategoryList( itemDto.getCategory() );
        brand = brandRequest.toBrand( itemDto.getBrand() );
        quantity = itemDto.getQuantity();
        price = itemDto.getPrice();
        id = itemDto.getId();
        name = itemDto.getName();
        description = itemDto.getDescription();

        Item item = new Item( id, name, description, quantity, price, category, brand );

        return item;
    }

    protected List<CategoryDto> categoryListToCategoryDtoList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDto> list1 = new ArrayList<CategoryDto>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryRequest.toCategoryDto( category ) );
        }

        return list1;
    }

    protected List<Category> categoryDtoListToCategoryList(List<CategoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryDto categoryDto : list ) {
            list1.add( categoryRequest.toCategory( categoryDto ) );
        }

        return list1;
    }
}
