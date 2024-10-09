package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.IncreaseStockDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.application.service.ItemService;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(InfraConstants.ITEM_PATH)
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping
    private List<ItemAuxDto> getItemList(){
        return itemService.getItemList();
    }

    @GetMapping(InfraConstants.ORDER)
    private Page<ItemAuxDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return itemService.getItemsOrdered(order, page, size);
    }
    @GetMapping(InfraConstants.TYPE_ORDER)
    private Page<ItemAuxDto> getCategories(
            @PathVariable String order,
            @PathVariable String variable,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return itemService.getItemsOrdered(order,variable, page, size);
    }

    @PostMapping
    @PreAuthorize(InfraConstants.HAS_ROLE_ADMIN)
    private void saveItem(@RequestBody ItemDto itemDto){
        itemService.saveItem(itemDto);
    }

    @PostMapping(InfraConstants.SUPPLY_PATH)
    @PreAuthorize(InfraConstants.HAS_WAREHOUSE_AUX_OR_ROLE_ADMIN)
    private ItemAuxDto increaseStock(@RequestBody IncreaseStockDto increaseStockDto) {
        return itemService.increaseStock(increaseStockDto.getArticleId(), increaseStockDto.getQuantity());
    }

}
