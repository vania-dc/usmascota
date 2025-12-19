package com.medipets.usmascota.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medipets.usmascota.model.MascotaEntity;

public interface MascotaRepository extends JpaRepository<MascotaEntity,Long>{
// Busca mascotas por el ID del cliente (Columna cliente_id en la tabla de Alan)
    List<MascotaEntity> findByClienteId(Long clienteId);    
}
