package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Item;

import java.util.List;

public interface ItemPersistencePort {
    List<Item> getItemsByCategoryId(Long id);

    Item saveItem(Item item);

    List<Item> getItemList();

    public Item getItem(String name);

    void updateItem(Item item);

    void deleteItem(String itemId);
}
