package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T21:41:23-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class BrandRequestImpl implements BrandRequest {

    @Override
    public Brand toBrand(BrandDto brand) {
        if ( brand == null ) {
            return null;
        }

        Brand brand1 = new Brand();

        brand1.setId( brand.getId() );
        brand1.setName( brand.getName() );
        brand1.setDescription( brand.getDescription() );

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
