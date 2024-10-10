package com.BootcampPragma.Api_Stock.domain.api;

import com.BootcampPragma.Api_Stock.domain.model.Item;

import java.util.List;

public interface ItemServicePort {

        Item saveItem(Item item);

        List<Item> getItemList();

        Item getItem(String name);
        Item getItem(long id);

        void updateItem(Item item);

        void deleteItem(String articleId);

        Item increaseStock(long articleId, int quantity);
}
