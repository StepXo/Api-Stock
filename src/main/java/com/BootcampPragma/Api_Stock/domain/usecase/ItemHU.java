package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Stock.domain.exeption.ActualizationItemExeption;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryListDuplicateExeption;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.spi.ItemPersistencePort;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemHU implements ItemServicePort {

    private final ItemPersistencePort itemPersistencePort;

    public ItemHU(ItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }

    @Override
    public Item saveItem(Item item){

        Set<Long> uniqueCategories = item.getCategory().stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
        if (item.getCategory().size() != uniqueCategories.size()) {
            throw new CategoryListDuplicateExeption();
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

    @Override
    public Item increaseStock(long articleId, int quantity) {
        for (int i = 0; i < 4; i++) {
            Item item = itemPersistencePort.getItem(articleId);
            System.out.println(item.getQuantity());

            item.setQuantity(item.getQuantity() + quantity);
            System.out.println(item.getQuantity());


            return itemPersistencePort.updateItem(item);
        }
        throw new ActualizationItemExeption();

    }

}
