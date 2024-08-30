package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.exeption.CategoryListDuplicateExeption;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;

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
        System.out.println(uniqueCategories.size());
        System.out.println(item.getCategory().size());
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

}
