package com.medipets.usmascota.dto;

import lombok.Data;

@Data
public class MascotaDTO {
    private Long id;
    private Long clienteId;
    private String nombre;
    private String tipo;
    private String raza;
    private Integer edadAnios;
    private String fotoUrl;
}
