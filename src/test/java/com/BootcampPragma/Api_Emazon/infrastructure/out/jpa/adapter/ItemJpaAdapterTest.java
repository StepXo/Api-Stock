package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.*;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ItemMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.BrandRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoryRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemJpaAdapterTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemMapper itemMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private ItemJpaAdapter itemJpaAdapter;

    private Item item;
    private ItemEntity itemEntity;
    private Category category;
    private CategoryEntity categoryEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(1L, "CategoryName","Category");
        categoryEntity = new CategoryEntity(1L, "CategoryName","Category");

        item = new Item(1L, "ItemName","description", 0, 0, List.of(category),null);
        itemEntity = new ItemEntity(1L, "ItemName","description", 0, 0, List.of(categoryEntity),null);
    }

    @Test
    void getItemList_NoDataFound() {
        when(itemRepository.findAll()).thenReturn(List.of());

        NoDataFoundException thrown = assertThrows(NoDataFoundException.class, () -> {
            itemJpaAdapter.getItemList();
        });

        assertNotNull(thrown);
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void getItemList_Success() {
        when(itemRepository.findAll()).thenReturn(List.of(itemEntity));
        when(itemMapper.toItem(itemEntity)).thenReturn(item);

        List<Item> items = itemJpaAdapter.getItemList();

        assertNotNull(items);
        assertEquals(1, items.size());
        assertEquals(item.getName(), items.get(0).getName());
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void getItem_Success() {
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.of(itemEntity));
        when(itemMapper.toItem(itemEntity)).thenReturn(item);

        Item foundItem = itemJpaAdapter.getItem("ItemName");

        assertNotNull(foundItem);
        assertEquals(item.getName(), foundItem.getName());
        verify(itemRepository, times(1)).findByName("ItemName");
    }

    @Test
    void getItem_NotFound() {
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.empty());

        ItemNotFoundException thrown = assertThrows(ItemNotFoundException.class, () -> {
            itemJpaAdapter.getItem("ItemName");
        });

        assertNotNull(thrown);
        verify(itemRepository, times(1)).findByName("ItemName");
    }

    @Test
    void getItemsByCategoryId_Success() {
        when(itemRepository.findByCategoryId(1L)).thenReturn(Optional.ofNullable(itemEntity));
        when(itemMapper.toItem(itemEntity)).thenReturn(item);

        List<Item> items = itemJpaAdapter.getItemsByCategoryId(1L);

        assertNotNull(items);
        assertEquals(1, items.size());
        assertEquals(item.getName(), items.get(0).getName());
        verify(itemRepository, times(1)).findByCategoryId(1L);
    }

    @Test
    void saveItem_Success() {
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.empty());
        when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(categoryEntity));
        when(itemMapper.toItemEntity(item)).thenReturn(itemEntity);
        when(itemRepository.save(itemEntity)).thenReturn(itemEntity);
        when(itemMapper.toItem(itemEntity)).thenReturn(item);

        Item savedItem = itemJpaAdapter.saveItem(item);

        assertNotNull(savedItem);
        assertEquals(item.getName(), savedItem.getName());
        verify(itemRepository, times(1)).save(itemEntity);
    }

    @Test
    void saveItem_ItemAlreadyExists() {
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.of(itemEntity));

        ItemAlreadyExistsException thrown = assertThrows(ItemAlreadyExistsException.class, () -> {
            itemJpaAdapter.saveItem(item);
        });

        assertNotNull(thrown);
        verify(itemRepository, never()).save(any());
    }

    @Test
    void saveItem_CategoryNotFound() {
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.empty());
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());

        CategoryNotFoundException thrown = assertThrows(CategoryNotFoundException.class, () -> {
            itemJpaAdapter.saveItem(item);
        });

        assertNotNull(thrown);
        verify(itemRepository, never()).save(any());
    }

    @Test
    void saveItem_BrandNotFound() {
        item.setBrand(new Brand(1L, "BrandName", "Description"));
        when(itemRepository.findByName("ItemName")).thenReturn(Optional.empty());
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categoryEntity));
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());

        BrandNotFoundException thrown = assertThrows(BrandNotFoundException.class, () -> {
            itemJpaAdapter.saveItem(item);
        });

        assertNotNull(thrown);
        verify(itemRepository, never()).save(any());
    }

}
