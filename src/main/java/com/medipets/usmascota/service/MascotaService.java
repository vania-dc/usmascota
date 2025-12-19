package com.medipets.usmascota.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medipets.usmascota.dto.MascotaDTO;
@Service
public interface MascotaService {
    MascotaDTO registrarMascota(MascotaDTO mascotaDTO);
    List<MascotaDTO> listarPorCliente(Long clienteId);
}
