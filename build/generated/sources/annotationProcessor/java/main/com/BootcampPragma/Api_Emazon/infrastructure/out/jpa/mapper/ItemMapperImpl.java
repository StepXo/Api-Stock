package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T12:47:47-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Item toItem(ItemEntity item) {
        if ( item == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        String description = null;
        long quantity = 0L;
        double price = 0.0d;
        List<Category> category = null;
        Brand brand = null;

        id = item.getId();
        name = item.getName();
        description = item.getDescription();
        quantity = item.getQuantity();
        price = item.getPrice();
        category = categoryEntityListToCategoryList( item.getCategory() );
        brand = brandMapper.toBrand( item.getBrand() );

        Item item1 = new Item( id, name, description, quantity, price, category, brand );

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
        itemEntity.setQuantity( item.getQuantity() );
        itemEntity.setPrice( item.getPrice() );
        itemEntity.setCategory( categoryListToCategoryEntityList( item.getCategory() ) );
        itemEntity.setBrand( brandMapper.toMarcaEntity( item.getBrand() ) );

        return itemEntity;
    }

    protected List<Category> categoryEntityListToCategoryList(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( categoryMapper.toCategory( categoryEntity ) );
        }

        return list1;
    }

    protected List<CategoryEntity> categoryListToCategoryEntityList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryEntity> list1 = new ArrayList<CategoryEntity>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryMapper.toCategoryEntity( category ) );
        }

        return list1;
    }
}
