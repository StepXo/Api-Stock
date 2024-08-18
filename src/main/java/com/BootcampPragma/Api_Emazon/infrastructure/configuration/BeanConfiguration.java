package com.BootcampPragma.Api_Emazon.infrastructure.configuration;

import com.BootcampPragma.Api_Emazon.domain.api.ArticleServicePort;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.spi.ArticlePersistencePort;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoryPersistencePort;
import com.BootcampPragma.Api_Emazon.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Emazon.domain.usecase.ArticleHU;
import com.BootcampPragma.Api_Emazon.domain.usecase.CategoryHU;
import com.BootcampPragma.Api_Emazon.domain.usecase.BrandHU;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.ArticleJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticleMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.BrandMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoryMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticleRepository;
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

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

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
    public ArticlePersistencePort articlePersistencePort(){
        return new ArticleJpaAdapter(articleRepository, articleMapper);
    }
    @Bean
    public ArticleServicePort articleServicePort(){
        return new ArticleHU(articlePersistencePort());
    }

}
