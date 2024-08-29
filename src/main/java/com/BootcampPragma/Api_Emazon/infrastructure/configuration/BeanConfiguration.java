package com.BootcampPragma.Api_Emazon.infrastructure.configuration;

import com.BootcampPragma.Api_Emazon.domain.api.ItemServicePort;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.spi.ItemPersistencePort;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoryPersistencePort;
import com.BootcampPragma.Api_Emazon.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Emazon.domain.usecase.ItemHU;
import com.BootcampPragma.Api_Emazon.domain.usecase.CategoryHU;
import com.BootcampPragma.Api_Emazon.domain.usecase.BrandHU;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.ItemJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ItemMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.BrandMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoryMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ItemRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoryRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Bean
    public CategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryMapper);
    }

    @Bean
    public CategoryServicePort categoryServicePort(){
        return new CategoryHU(categoryPersistencePort());
    }

    @Bean
    public BrandPersistencePort brandPersistencePort(){
        return new BrandJpaAdapter(brandRepository, brandMapper);
    }

    @Bean
    public BrandServicePort brandServicePort(){
        return new BrandHU(brandPersistencePort());
    }

    @Bean
    public ItemPersistencePort itemPersistencePort(){
        return new ItemJpaAdapter(itemRepository, itemMapper,categoryRepository);
    }
    @Bean
    public ItemServicePort itemServicePort(){
        return new ItemHU(itemPersistencePort());
    }

}
