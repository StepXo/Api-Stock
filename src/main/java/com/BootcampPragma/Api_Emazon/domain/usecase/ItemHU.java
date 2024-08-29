package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;

import java.util.List;

public class ItemHU implements ItemServicePort {

    private final ItemPersistencePort itemPersistencePort;

    public ItemHU(ItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }

    @Override
    public Item saveItem(Item item) {
        if (item.getCategory_id().isEmpty()) {
            throw null; //error id faltante
        }
        if (item.getCategory_id().size() > 3) {
            throw null; //error lista muy grande
        }
        return itemPersistencePort.saveItem(item);
    }

    @Override
    public List<Item> getItemList() {
        return itemPersistencePort.getItemList();
    }

    @Override
    public Item getItem(String name) {
        return itemPersistencePort.getItem(name);
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
