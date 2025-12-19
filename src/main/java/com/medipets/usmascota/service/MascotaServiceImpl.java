package com.medipets.usmascota.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medipets.usmascota.dto.MascotaDTO;
import com.medipets.usmascota.model.MascotaEntity;
import com.medipets.usmascota.repository.MascotaRepository;
@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaRepository repository;

    @Override
    public MascotaDTO registrarMascota(MascotaDTO dto) {
        MascotaEntity entity = new MascotaEntity();
        // Mapeo manual (o puedes usar ModelMapper)
        entity.setNombre(dto.getNombre());
        entity.setClienteId(dto.getClienteId());
        entity.setTipo(dto.getTipo());
        entity.setRaza(dto.getRaza());
        entity.setEdadAnios(dto.getEdadAnios());
        entity.setFotoUrl(dto.getFotoUrl());

        entity = repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<MascotaDTO> listarPorCliente(Long clienteId) {
        return repository.findByClienteId(clienteId).stream().map(m -> {
            MascotaDTO dto = new MascotaDTO();
            dto.setId(m.getId());
            dto.setNombre(m.getNombre());
            dto.setRaza(m.getRaza());
            return dto;
        }).collect(Collectors.toList());
    }

     @Override
    public void eliminarMascota(Long mascotaId) {

        if (!repository.existsById(mascotaId)) {
            throw new RuntimeException("La mascota no existe");
        }

        repository.deleteById(mascotaId);
    }
}
