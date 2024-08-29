package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.BrandEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T22:07:42-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandEntity brand) {
        if ( brand == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        String description = null;

        id = brand.getId();
        name = brand.getName();
        description = brand.getDescription();

        Brand brand1 = new Brand( id, name, description );

        return brand1;
    }

    @Override
    public BrandEntity toMarcaEntity(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setId( brand.getId() );
        brandEntity.setName( brand.getName() );
        brandEntity.setDescription( brand.getDescription() );

        return brandEntity;
    }
}
