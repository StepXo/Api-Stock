package com.BootcampPragma.Api_Stock.application.util;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaginationUtil {

    public Page<ItemAuxDto> getItemsPagination(String order, int page, int size, List<ItemAuxDto> sortedItemDto){
        Sort sort = "asc".equalsIgnoreCase(order)
                ? Sort.by("name").descending()
                : Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedItemDto.size());

        return new PageImpl<>(sortedItemDto.subList(start, end), pageable, sortedItemDto.size());
    }

    public Page<CategoryDto> getCategoriesPagination(String order, int page, int size, List<CategoryDto> sortedCategoryDto) {
        Sort sort = "asc".equalsIgnoreCase(order)
                ? Sort.by("name").descending()
                : Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedCategoryDto.size());

        return new PageImpl<>(sortedCategoryDto.subList(start, end), pageable, sortedCategoryDto.size());
    }
    public Page<BrandDto> getBrandsPagination(String order, int page, int size, List<BrandDto> sortedBrandDto) {

        Sort sort = "asc".equalsIgnoreCase(order)
                ? Sort.by("name").descending()
                : Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedBrandDto.size());

        return new PageImpl<>(sortedBrandDto.subList(start, end), pageable, sortedBrandDto.size());
    }

}
