package com.BootcampPragma.Api_Emazon.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloDto {
    private long id;
    private String nombre;
    private String descripcion;
    private long cantidad;
    private double precio;

}
