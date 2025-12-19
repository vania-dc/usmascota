package com.medipets.usmascota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medipets.usmascota.dto.MascotaDTO;
import com.medipets.usmascota.service.MascotaService;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {
    @Autowired
    private MascotaService service;

    @PostMapping("/crear")
    public ResponseEntity<MascotaDTO> crear(@RequestBody MascotaDTO dto) {
        return ResponseEntity.ok(service.registrarMascota(dto));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<MascotaDTO>> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorCliente(id));
    }
}
