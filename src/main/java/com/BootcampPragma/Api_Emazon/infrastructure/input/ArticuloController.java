package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.application.service.ArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@RequiredArgsConstructor
public class ArticuloController {

    private final ArticuloService articuloService;


    @GetMapping
    private List<ArticuloDto> obtenerArticulo(){
        return articuloService.obtenerArticulos();
    }

    @PostMapping
    private void crearArticulo(@RequestBody ArticuloDto articulo){
        articuloService.crearArticulo(articulo);
    }

}
