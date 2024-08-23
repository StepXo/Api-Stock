package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Item;

import java.util.List;

public interface
ItemServicePort {

        Item saveItem(Item item);

        List<Item> getItemList();

        void updateItem(Item item);

        void deleteItem(String articleId);
}
