package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Item;

import java.util.List;

public interface ItemPersistencePort {
    Item saveItem(Item item);

    List<Item> getItemList();

    void updateItem(Item item);

    void deleteItem(String itemId);
}
