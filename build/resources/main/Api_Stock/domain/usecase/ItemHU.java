package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.spi.ItemPersistencePort;

import java.util.List;

public class ItemHU implements ItemServicePort {

    private final ItemPersistencePort itemPersistencePort;

    public ItemHU(ItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }

    @Override
    public Item saveItem(Item item) {
        return itemPersistencePort.saveItem(item);
    }

    @Override
    public List<Item> getItemList() {
        return itemPersistencePort.getItemList();
    }

    @Override
    public void updateItem(Item item) {
        itemPersistencePort.saveItem(item);
    }

    @Override
    public void deleteItem(String articleId) {
        itemPersistencePort.deleteItem(articleId);
    }

}
