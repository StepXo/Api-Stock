package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter.MarcaJpaAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaJpaAdapter marcaService;


    @GetMapping
    private List<MarcaDto> obtenerMarca(){
        return marcaService.obtenerMarcas();
    }

    @PostMapping
    private MarcaDto crearMarca(@RequestBody MarcaDto marca){
        return marcaService.crearMarca(marca);
    }

}
