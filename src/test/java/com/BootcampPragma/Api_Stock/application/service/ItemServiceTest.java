package com.BootcampPragma.Api_Stock.application.service;

import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemAuxDto;
import com.BootcampPragma.Api_Stock.application.dto.ItemDto;
import com.BootcampPragma.Api_Stock.application.mapper.ItemRequest;
import com.BootcampPragma.Api_Stock.application.util.PaginationUtil;
import com.BootcampPragma.Api_Stock.application.util.SorterUtil;
import com.BootcampPragma.Api_Stock.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryListSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @Mock
    private ItemRequest itemRequest;

    @Mock
    private ItemServicePort itemServicePort;

    @Mock
    private SorterUtil sorterUtil;

    @Mock
    private PaginationUtil paginationUtil;

    @InjectMocks
    private ItemService itemService;
    private Item item;
    private ItemDto itemDto;
    private ItemAuxDto itemAuxDto;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        item = new Item(1L, "Item1","desc",0,0, Collections.emptyList(),null);
        itemDto = new ItemDto(1L, "Item1","desc",0,0, Arrays.asList(1L, 2L, 3L),null);
        itemAuxDto = new ItemAuxDto(1L, "Item1","desc",0,0,Arrays.asList(new CategoryDto(), new CategoryDto()),null);
    }

    @Test
    void getItemList_Success() {
        when(itemServicePort.getItemList()).thenReturn(Collections.singletonList(item));
        when(itemRequest.toItemDto(item)).thenReturn(itemAuxDto);
        List<ItemAuxDto> itemAuxDtos = itemService.getItemList();

        assertNotNull(itemAuxDtos);
        assertEquals(1, itemAuxDtos.size());
        assertEquals("Item1", itemAuxDtos.get(0).getName());
        verify(itemServicePort, times(1)).getItemList();
        verify(itemRequest, times(1)).toItemDto(item);
    }
    @Test
    void testGetItemsOrderedWithoutVariable() {

        List<Item> itemList = new ArrayList<>(Collections.singletonList(item));
        List<ItemAuxDto> itemAuxDtoList = new ArrayList<>(Collections.singletonList(itemAuxDto));

        when(itemServicePort.getItemList()).thenReturn(itemList);
        when(itemRequest.toItemDto(item)).thenReturn(itemAuxDto);
        when(sorterUtil.getSortedItems(eq("asc"), anyList())).thenReturn(itemAuxDtoList);

        Page<ItemAuxDto> pagedResult = new PageImpl<>(itemAuxDtoList, PageRequest.of(0, 10), 1);
        when(paginationUtil.getItemsPagination(eq("asc"), eq(0), eq(10), anyList())).thenReturn(pagedResult);
        Page<ItemAuxDto> result = itemService.getItemsOrdered("asc", 0, 10);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(itemAuxDto, result.getContent().get(0));
    }

    @Test
    void testGetItemsOrderedWithVariable() {
        List<Item> itemList = Collections.singletonList(item);
        List<ItemAuxDto> itemAuxDtoList = Collections.singletonList(itemAuxDto);

        when(itemServicePort.getItemList()).thenReturn(itemList);
        when(itemRequest.toItemDto(any(Item.class))).thenReturn(itemAuxDto);
        when(sorterUtil.getSortedItems(eq("asc"), eq("brand"), anyList())).thenReturn(itemAuxDtoList);

        Page<ItemAuxDto> pagedResult = new PageImpl<>(itemAuxDtoList, PageRequest.of(0, 10), 1);
        when(paginationUtil.getItemsPagination(eq("asc"), eq(0), eq(10), anyList())).thenReturn(pagedResult);
        Page<ItemAuxDto> result = itemService.getItemsOrdered("asc", "brand", 0, 10);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(itemAuxDto, result.getContent().get(0));
    }


    @Test
    void saveItem_ValidItem_Success() {
        when(itemRequest.toItem(itemDto)).thenReturn(item);
        itemService.saveItem(itemDto);

        verify(itemRequest, times(1)).toItem(itemDto);
        verify(itemServicePort, times(1)).saveItem(item);
    }

    @Test
    void saveItem_EmptyCategoryList_ThrowsException() {
        itemDto = new ItemDto(1L, "Item1","desc",0,0, Collections.emptyList(),null);

        assertThrows(CategoryListSizeException.class, () -> itemService.saveItem(itemDto));
    }

    @Test
    void saveItem_TooManyCategories_ThrowsException() {
        // Arrange
        itemDto = new ItemDto(1L, "Item1","desc",0,0, Arrays.asList(1L, 2L, 3L,4L),null);

        // Act & Assert
        assertThrows(CategoryListSizeException.class, () -> itemService.saveItem(itemDto));
    }

    @Test
    void getItem_Success() {

        when(itemServicePort.getItem("Item1")).thenReturn(item);
        when(itemRequest.toItemDto(item)).thenReturn(itemAuxDto);
        ItemAuxDto result = itemService.getItem("Item1");

        assertNotNull(result);
        assertEquals("Item1", result.getName());
        verify(itemServicePort, times(1)).getItem("Item1");
        verify(itemRequest, times(1)).toItemDto(item);
    }
}
