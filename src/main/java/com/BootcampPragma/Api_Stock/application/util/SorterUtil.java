package com.BootcampPragma.Api_Stock.application.util;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SorterUtil {

    public List<BrandDto> getSortedBrands(String order,List<BrandDto> brandDto) {

        Comparator<BrandDto> comparator = AppConstant.ORDER.equalsIgnoreCase(order)
                ? Comparator.comparing(BrandDto::getName)
                : Comparator.comparing(BrandDto::getName).reversed();

        return brandDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<CategoryDto> getSortedCategories(String order, List<CategoryDto> categoryDto) {

        Comparator<CategoryDto> comparator = AppConstant.ORDER.equalsIgnoreCase(order)
                ? Comparator.comparing(CategoryDto::getName)
                : Comparator.comparing(CategoryDto::getName).reversed();

        return categoryDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<ItemAuxDto> getSortedItems(String order,List<ItemAuxDto> itemAuxDto) {

        Comparator<ItemAuxDto> comparator = AppConstant.ORDER.equalsIgnoreCase(order)
                ? Comparator.comparing(ItemAuxDto::getName)
                : Comparator.comparing(ItemAuxDto::getName).reversed();

        return itemAuxDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<ItemAuxDto> getSortedItems(String order, String attribute,List<ItemAuxDto> itemAuxDtoList) {

        Comparator<ItemAuxDto> comparator = switch (attribute.toLowerCase()) {
            case AppConstant.BRAND -> AppConstant.ORDER.equalsIgnoreCase(order)
                    ? Comparator.comparing((ItemAuxDto item) -> item.getBrand().getName())
                    : Comparator.comparing((ItemAuxDto item) -> item.getBrand().getName()).reversed();
            case AppConstant.CATEGORY -> {
                itemAuxDtoList.forEach(item ->
                        item.setCategory(getSortedCategories(order, item.getCategory()))
                );
                yield AppConstant.ORDER.equalsIgnoreCase(order)
                        ? Comparator.comparing((ItemAuxDto item) -> item.getCategory().get(AppConstant.FIRST).getName())
                        : Comparator.comparing((ItemAuxDto item) -> item.getCategory().get(AppConstant.FIRST).getName()).reversed();
            }
            default -> throw new IllegalArgumentException(AppConstant.ERROR + attribute);
        };

        List<ItemAuxDto> filteredItems = AppConstant.BRAND.equalsIgnoreCase(attribute)
                ? itemAuxDtoList.stream()
                .filter(item -> item.getBrand() != null)
                .toList()
                : itemAuxDtoList;

        return filteredItems.stream()
                .sorted(comparator)
                .toList();
    }
}

