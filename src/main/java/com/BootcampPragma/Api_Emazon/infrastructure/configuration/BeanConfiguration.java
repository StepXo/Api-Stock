package com.BootcampPragma.Api_Emazon.infrastructure.configuration;

import com.BootcampPragma.Api_Emazon.domain.spi.CategoriaPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.CategoriaJpaAdapter;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticuloMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoriaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.MarcaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticuloRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoriaRepository;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;
    private final ArticuloRepository articuloRepository;
    private final ArticuloMapper articuloMapper;

    @Bean
    public CategoriaPersistencePort categoriaPersistencePort(){
        return new CategoriaJpaAdapter(categoriaRepository,categoriaMapper);
    }

    @Bean
    public
}
