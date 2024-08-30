package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.exeption.CategoryListDuplicateExeption;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemHUTest {

    @Mock
    private ItemPersistencePort itemPersistencePort;

    @InjectMocks
    private ItemHU itemHU;
    private Item item;
    private Category cat1;
    private Category cat2;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cat1 = new Category(1L, "Cat1","description");
        cat2 = new Category(2L, "Cat2","description");
        item = new Item(1L, "Item1","desc",0,0, Arrays.asList(cat1, cat2),null);

    }

    @Test
    void saveItem_Success() {

        when(itemPersistencePort.saveItem(item)).thenReturn(item);
        Item savedItem = itemHU.saveItem(item);

        assertNotNull(savedItem);
        assertEquals(item.getName(), savedItem.getName());
        verify(itemPersistencePort, times(1)).saveItem(item);
    }

    @Test
    void saveItem_DuplicateCategories_ThrowsException() {
        item = new Item(1L, "Item1","desc",0,0, Arrays.asList(cat1, cat1),null);

        assertThrows(CategoryListDuplicateExeption.class, () -> itemHU.saveItem(item));
    }

    @Test
    void getItemList_Success() {
        when(itemPersistencePort.getItemList()).thenReturn(Arrays.asList(item));
        List<Item> items = itemHU.getItemList();

        assertNotNull(items);
        assertEquals(1, items.size());
        assertEquals(item.getName(), items.get(0).getName());
        verify(itemPersistencePort, times(1)).getItemList();
    }

    @Test
    void getItem_Success() {
        when(itemPersistencePort.getItem("Item1")).thenReturn(item);
        Item fetchedItem = itemHU.getItem("Item1");

        assertNotNull(fetchedItem);
        assertEquals(item.getName(), fetchedItem.getName());
        verify(itemPersistencePort, times(1)).getItem("Item1");
    }
}
