package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.application.service.ItemService;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(InfraConstants.ITEM)
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping
    private ResponseEntity<List<ItemAuxDto>> getItemList(){
        return ResponseEntity.ok(itemService.getItemList());
    }

    @GetMapping(InfraConstants.ORDER)
    private ResponseEntity<Page<ItemAuxDto>> getAllItems(
            @PathVariable String order,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return ResponseEntity.ok(itemService.getItemsOrdered(order, page, size));
    }

    @GetMapping(InfraConstants.TYPE_ORDER)
    private ResponseEntity<Page<ItemAuxDto>> getAllItems(
            @PathVariable String order,
            @PathVariable String variable,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return ResponseEntity.ok(itemService.getItemsOrdered(order,variable, page, size));
    }

    @PostMapping
    @PreAuthorize(InfraConstants.HAS_ROLE_ADMIN)
    private void saveItem(@RequestBody ItemDto itemDto){
        itemService.saveItem(itemDto);
    }

    @PostMapping(InfraConstants.SUPPLY)
    @PreAuthorize(InfraConstants.HAS_WAREHOUSE_AUX_OR_ROLE_ADMIN)
    private ResponseEntity<ItemAuxDto> increaseStock(@RequestBody ItemAuxDto increaseStockDto) {
        return ResponseEntity.ok(itemService.increaseStock(increaseStockDto.getId(),(int) increaseStockDto.getQuantity()));
    }

    @GetMapping(InfraConstants.GET_ID)
    @PreAuthorize(InfraConstants.HAS_USER_OR_ROLE_ADMIN)
    private void checkStock(@PathVariable Long id,
                                  @RequestParam long quantity) {
        itemService.checkStock(id, quantity);
    }

    @GetMapping(InfraConstants.CART)
    public ResponseEntity<List<ItemAuxDto>> getItemsByList(@RequestParam List<Long> list) {
        return ResponseEntity.ok(itemService.getItemsByList(list));
    }

    @PostMapping(InfraConstants.BUY)
    public ResponseEntity<List<Integer>> buy(@RequestBody List<ItemAuxDto> list) {
        return ResponseEntity.ok(itemService.buy(list));
    }

}
