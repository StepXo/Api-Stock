package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.application.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping
    private List<ItemDto> getItemList(){
        return itemService.getItemList();
    }

    @PostMapping
    private void saveItem(@RequestBody ItemDto article){
        itemService.saveItem(article);
    }

}
