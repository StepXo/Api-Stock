package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.ArticuloJpaAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@RequiredArgsConstructor
public class ArticuloController {

    private final ArticuloJpaAdapter articuloService;


    @GetMapping
    private List<ArticuloDto> obtenerArticulo(){
        return articuloService.obtenerArticulos();
    }

    @PostMapping
    private ArticuloDto crearArticulo(@RequestBody ArticuloDto articulo){
        return articuloService.crearArticulo(articulo);
    }

}
