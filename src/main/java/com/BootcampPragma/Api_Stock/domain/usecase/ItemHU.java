package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.Utils.Validation;
import com.BootcampPragma.Api_Stock.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Stock.domain.exeption.ActualizationItemExeption;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryListDuplicateExeption;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Stock.domain.spi.CategoryPersistencePort;
import com.BootcampPragma.Api_Stock.domain.spi.ItemPersistencePort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemHU implements ItemServicePort {

    private final ItemPersistencePort itemPersistencePort;
    private final CategoryPersistencePort categoryPersistencePort;
    private final BrandPersistencePort brandPersistencePort;

    public ItemHU(ItemPersistencePort itemPersistencePort, CategoryPersistencePort categoryPersistencePort, BrandPersistencePort brandPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
        this.categoryPersistencePort = categoryPersistencePort;
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public Item saveItem(Item item){

        Item repository = itemPersistencePort.getItem(item.getName());
        List<Category> categoryList = new ArrayList<>();
        Brand brand = brandPersistencePort.getBrand(item.getBrand().getId());

        for (Category category : item.getCategory()){
            categoryList.add(categoryPersistencePort.getCategory(category.getId()));
        }

        Validation.validate(item,repository,categoryList,brand);

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

            item.setQuantity(item.getQuantity() + quantity);

            try {
                return itemPersistencePort.updateItem(item);
            } catch (RuntimeException e) {
                if (i == 3)break;
            }
        }
        throw new ActualizationItemExeption();

    }

}
