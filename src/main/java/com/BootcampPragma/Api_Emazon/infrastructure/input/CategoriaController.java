package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.application.service.CategoriaService;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.CategoriaJpaAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;


    @GetMapping
    private List<CategoriaDto> obtenerCategoria(){
        return categoriaService.obtenerCategorias();
    }

    @PostMapping
    private void crearCategoria(@RequestBody CategoriaDto categoria){
        categoriaService.crearCategoria(categoria);
    }

}
