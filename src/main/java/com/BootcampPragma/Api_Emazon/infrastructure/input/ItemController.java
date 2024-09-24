package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Emazon.application.dto.ItemDto;
import com.BootcampPragma.Api_Emazon.application.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping
    private List<ItemAuxDto> getItemList(){
        return itemService.getItemList();
    }

    @GetMapping("/{order}")
    private Page<ItemAuxDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return itemService.getItemsOrdered(order, page, size);
    }
    @GetMapping("/{order}/{variable}")
    private Page<ItemAuxDto> getCategories(
            @PathVariable String order,
            @PathVariable String variable,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return itemService.getItemsOrdered(order,variable, page, size);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    private void saveItem(@RequestBody ItemDto itemDto){
        itemService.saveItem(itemDto);
    }

}
