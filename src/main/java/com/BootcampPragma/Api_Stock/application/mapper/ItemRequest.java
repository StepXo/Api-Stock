package com.BootcampPragma.Api_Stock.application.mapper;

import com.BootcampPragma.Api_Stock.application.util.AppConstant;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = AppConstant.SPRING,uses = {CategoryRequest.class, BrandRequest.class})
public interface ItemRequest {

    ItemAuxDto toItemDto(Item item);

    @Mappings({
            @Mapping(source = AppConstant.CATEGORY_ID,target = AppConstant.CATEGORY,qualifiedByName = AppConstant.MAP_TO_CATEGORIES),
            @Mapping(source = AppConstant.BRAND_ID,target = AppConstant.BRAND,qualifiedByName = AppConstant.TO_BRAND)
    })
    Item toItem(ItemDto itemDto);

    @Named(AppConstant.MAP_TO_CATEGORIES)
    default List<Category> mapToCategories (List<Long> categoryIds){
        List<Category> categories = new ArrayList<>();

        if (!categoryIds.isEmpty()){
            for (Long category_Id : categoryIds){
                categories.add(new Category(category_Id, AppConstant.EMPTY_STRING, AppConstant.EMPTY_STRING));
            }
        }
        return categories;
    }

    @Named(AppConstant.TO_BRAND)
    default Brand toBrand(Long brandId){
        if (brandId == null  ) {
            return null;
        } else{
            return new Brand(brandId, AppConstant.EMPTY_STRING, AppConstant.EMPTY_STRING);
        }
    }

}
