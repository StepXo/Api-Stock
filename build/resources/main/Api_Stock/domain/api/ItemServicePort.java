package com.BootcampPragma.Api_Stock.domain.api;

import com.BootcampPragma.Api_Stock.domain.model.Item;

import java.util.List;

public interface ItemServicePort {

        Item saveItem(Item item);

        List<Item> getItemList();

        void updateItem(Item item);

        void deleteItem(String articleId);
}
