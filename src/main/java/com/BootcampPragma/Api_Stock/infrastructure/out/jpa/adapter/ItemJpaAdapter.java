package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Stock.domain.exeption.BrandNotFoundException;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryNotFoundException;
import com.BootcampPragma.Api_Stock.domain.exeption.ItemAlreadyExistsException;
import com.BootcampPragma.Api_Stock.domain.exeption.ItemNotFoundException;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;
import com.BootcampPragma.Api_Stock.domain.spi.ItemPersistencePort;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.ItemEntity;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper.ItemMapper;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository.BrandRepository;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository.CategoryRepository;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class ItemJpaAdapter implements ItemPersistencePort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;



    @Override
    public List<Item> getItemList() {
        return itemRepository
                .findAll()
                .stream()
                .map(itemMapper::toItem)
                .toList();
    }

    @Override
    public Item getItem(String name) {
        return itemMapper.toItem(itemRepository.findByName(name)
                .orElseThrow(ItemNotFoundException::new));
    }

    @Override
    public Item getItem(long id) {
        return itemRepository.findById(id)
                .map(itemMapper::toItem)
                .orElse(null);
    }

    @Override
    public List<Item> getItemsByCategoryId(Long id) {
        return itemRepository.findByCategoryId(id)
                .stream()
                .map(itemMapper::toItem)
                .toList();
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
        ItemEntity itemEntity = itemRepository.save(itemMapper.toItemEntity(item));
        return itemMapper.toItem(itemEntity);
    }

    @Override
    public Item updateItem(Item item){
        return itemMapper.toItem(itemRepository.save(itemMapper.toItemEntity(item)));
    }

    @Override
    public void deleteItem(String itemName){
        itemRepository.deleteByName(itemName);}

}
