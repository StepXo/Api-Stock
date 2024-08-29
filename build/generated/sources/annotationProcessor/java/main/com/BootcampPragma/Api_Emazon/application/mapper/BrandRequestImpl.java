package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T22:07:42-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class BrandRequestImpl implements BrandRequest {

    @Override
    public Brand toBrand(BrandDto brand) {
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
    public BrandDto toBrandDto(Brand brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        BrandDto brandDto1 = new BrandDto();

        brandDto1.setId( brandDto.getId() );
        brandDto1.setName( brandDto.getName() );
        brandDto1.setDescription( brandDto.getDescription() );

        return brandDto1;
    }
}
