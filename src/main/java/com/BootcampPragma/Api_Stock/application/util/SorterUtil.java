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

        Comparator<BrandDto> comparator = "asc".equalsIgnoreCase(order)
                ? Comparator.comparing(BrandDto::getName)
                : Comparator.comparing(BrandDto::getName).reversed();

        return brandDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<CategoryDto> getSortedCategories(String order, List<CategoryDto> categoryDto) {

        Comparator<CategoryDto> comparator = "asc".equalsIgnoreCase(order)
                ? Comparator.comparing(CategoryDto::getName)
                : Comparator.comparing(CategoryDto::getName).reversed();

        return categoryDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<ItemAuxDto> getSortedItems(String order,List<ItemAuxDto> itemAuxDto) {

        Comparator<ItemAuxDto> comparator = "asc".equalsIgnoreCase(order)
                ? Comparator.comparing(ItemAuxDto::getName)
                : Comparator.comparing(ItemAuxDto::getName).reversed();

        return itemAuxDto.stream()
                .sorted(comparator)
                .toList();
    }

    public List<ItemAuxDto> getSortedItems(String order, String attribute,List<ItemAuxDto> itemAuxDtoList) {

        Comparator<ItemAuxDto> comparator = switch (attribute.toLowerCase()) {
            case "brand" -> "asc".equalsIgnoreCase(order)
                    ? Comparator.comparing((ItemAuxDto item) -> item.getBrand().getName())
                    : Comparator.comparing((ItemAuxDto item) -> item.getBrand().getName()).reversed();
            case "category" -> {
                itemAuxDtoList.forEach(item ->
                        item.setCategory(getSortedCategories(order, item.getCategory()))
                );
                yield "asc".equalsIgnoreCase(order)
                        ? Comparator.comparing((ItemAuxDto item) -> item.getCategory().get(0).getName())
                        : Comparator.comparing((ItemAuxDto item) -> item.getCategory().get(0).getName()).reversed();
            }
            default -> throw new IllegalArgumentException("Invalid attribute: " + attribute);
        };

        List<ItemAuxDto> filteredItems = "brand".equalsIgnoreCase(attribute)
                ? itemAuxDtoList.stream()
                .filter(item -> item.getBrand() != null)
                .toList()
                : itemAuxDtoList;

        return filteredItems.stream()
                .sorted(comparator)
                .toList();
    }
}

