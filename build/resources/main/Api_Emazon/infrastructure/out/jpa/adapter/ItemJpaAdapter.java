package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Item;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.BrandAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ItemMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class ItemJpaAdapter implements ItemPersistencePort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<Item> getItemList() {

        List<ItemEntity> itemEntityList = itemRepository.findAll();
        if (itemEntityList.isEmpty()){throw new NoDataFoundException();}

        return itemRepository
                .findAll()
                .stream()
                .map(itemMapper::toItem)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Item saveItem(Item item){

        if (itemRepository.findByName(item.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        } else if (item.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        ItemEntity itemEntity = this.itemRepository.save(
                itemMapper.toItemEntity(item)
        );
        return itemMapper.toItem(itemEntity);
    }

    @Override
    public void updateItem(Item item){

        if (itemRepository.findByName(item.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        } else if (item.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }
        ItemEntity itemEntity = this.itemRepository.save(
                itemMapper.toItemEntity(item));
    };

    @Override
    public void deleteItem(String itemId){
        itemRepository.deleteByName(itemId);}

}
