package com.BootcampPragma.Api_Stock.application.mapper;

import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-14T17:56:16-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ItemRequestImpl implements ItemRequest {

    @Autowired
    private CategoryRequest categoryRequest;
    @Autowired
    private BrandRequest brandRequest;

    @Override
    public ItemAuxDto toItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemAuxDto itemAuxDto = new ItemAuxDto();

        itemAuxDto.setId( item.getId() );
        itemAuxDto.setName( item.getName() );
        itemAuxDto.setDescription( item.getDescription() );
        itemAuxDto.setQuantity( item.getQuantity() );
        itemAuxDto.setPrice( item.getPrice() );
        itemAuxDto.setCategory( categoryListToCategoryDtoList( item.getCategory() ) );
        itemAuxDto.setBrand( brandRequest.toBrandDto( item.getBrand() ) );

        return itemAuxDto;
    }

    @Override
    public Item toItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setCategory( mapToCategories( itemDto.getCategoryId() ) );
        item.setBrand( toBrand( itemDto.getBrandId() ) );
        item.setId( itemDto.getId() );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setQuantity( itemDto.getQuantity() );
        item.setPrice( itemDto.getPrice() );

        return item;
    }

    @Override
    public Item toItem(ItemAuxDto item) {
        if ( item == null ) {
            return null;
        }

        Item item1 = new Item();

        item1.setId( item.getId() );
        item1.setName( item.getName() );
        item1.setDescription( item.getDescription() );
        item1.setQuantity( item.getQuantity() );
        item1.setPrice( item.getPrice() );
        item1.setCategory( categoryDtoListToCategoryList( item.getCategory() ) );
        item1.setBrand( brandRequest.toBrand( item.getBrand() ) );

        return item1;
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
