package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.*;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ItemMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.BrandRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoryRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class ItemJpaAdapter implements ItemPersistencePort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;



    @Override
    public List<Item> getItemList() {

        List<ItemEntity> itemEntityList = itemRepository.findAll();
        if (itemEntityList.isEmpty()){throw new NoDataFoundException();}

        return itemRepository
                .findAll()
                .stream()
                .map(itemMapper::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public Item getItem(String name) {
        return itemMapper.toItem(itemRepository.findByName(name)
                .orElseThrow(ItemNotFoundException::new));
    }

    @Override
    public List<Item> getItemsByCategoryId(Long id) {
        return itemRepository.findByCategoryId(id)
                .stream()
                .map(itemMapper::toItem)
                .collect(Collectors.toList());
    }

    @Override
    public Item saveItem(Item item) {
        if (itemRepository.findByName(item.getName()).isPresent()) {
            throw new ItemAlreadyExistsException();
        }
        for (Category category : item.getCategory()) {
            if (categoryRepository.findById(category.getId()).isEmpty()) {
                throw new CategoryNotFoundException();
            }
        }
        if (item.getBrand() != null && brandRepository.findById(item.getBrand().getId()).isEmpty()) {
            throw new BrandNotFoundException();
        }
        ItemEntity itemEntity = itemMapper.toItemEntity(item);
        itemEntity = itemRepository.save(itemEntity);
        return itemMapper.toItem(itemEntity);
    }

    @Override
    public void updateItem(Item item){
        ItemEntity itemEntity = itemRepository.findById(item.getId())
                .orElseThrow(ItemNotFoundException::new);

        itemRepository.save(itemEntity);
    }

    @Override
    public void deleteItem(String itemName){
        itemRepository.deleteByName(itemName);}

}
