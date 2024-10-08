package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Item;

import java.util.List;

public interface ItemPersistencePort {
    List<Item> getItemsByCategoryId(Long id);

    Item saveItem(Item item);

    List<Item> getItemList();

    Item getItem(String name);
    Item getItem(long id);


    Item updateItem(Item item);

    void deleteItem(String itemId);
}
