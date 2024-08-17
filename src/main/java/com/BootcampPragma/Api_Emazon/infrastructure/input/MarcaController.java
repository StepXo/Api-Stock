package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.application.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;


    @GetMapping
    private List<MarcaDto> obtenerMarca(){
        return marcaService.obtenerMarcas();
    }

    @PostMapping
    private void crearMarca(@RequestBody MarcaDto marca){
         marcaService.crearMarca(marca);
    }

}
