package com.medipets.usmascota.service;

import java.util.List;

import com.medipets.usmascota.dto.MascotaDTO;

public interface MascotaService {
    MascotaDTO registrarMascota(MascotaDTO mascotaDTO);
    List<MascotaDTO> listarPorCliente(Long clienteId);
}
