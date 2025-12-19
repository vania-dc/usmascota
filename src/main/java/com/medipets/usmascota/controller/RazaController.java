package com.medipets.usmascota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medipets.usmascota.service.RazaService;

@RestController
@RequestMapping("/api/razas")
@CrossOrigin("*")
public class RazaController {

    @Autowired
    private RazaService razaService;

    @GetMapping
    public ResponseEntity<List<String>> obtenerRazas(
            @RequestParam String tipo
    ) {
        return ResponseEntity.ok(
                razaService.obtenerRazasPorTipo(tipo)
        );
    }
}

