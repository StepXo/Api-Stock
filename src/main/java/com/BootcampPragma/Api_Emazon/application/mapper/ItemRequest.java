package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "Spring",uses = {CategoryRequest.class, BrandRequest.class})
public interface ItemRequest {

    ItemAuxDto toItemDto(Item item);

    @Mappings({
            @Mapping(source = "categoryId",target = "category",qualifiedByName = "map_to_categories"),
            @Mapping(source = "brandId",target = "brand",qualifiedByName = "to_brand")
    })
    Item toItem(ItemDto itemDto);

    @Named("map_to_categories")
    default List<Category> mapToCategories (List<Long> categoryIds){
        List<Category> categories = new ArrayList<>();

        if (!categoryIds.isEmpty()){
            for (Long category_Id : categoryIds){
                categories.add(new Category(category_Id,"",""));
            }
        }
        return categories;
    }

    @Named("to_brand")
    default Brand toBrand(Long brandId){
        if (brandId == null  ) {
            return null;
        } else{
            return new Brand(brandId, "", "");
        }
    }

}
