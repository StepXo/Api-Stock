package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.CategoriaJpaAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaJpaAdapter categoriaService;


    @GetMapping
    private List<Categoria> obtenerCategoria(){
        return categoriaService.obtenerCategorias();
    }

    @PostMapping
    private Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.crearCategoria(categoria);
    }

}
