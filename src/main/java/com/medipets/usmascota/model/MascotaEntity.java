package com.medipets.usmascota.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data               // Genera Getters, Setters, equals, hashCode y toString
@NoArgsConstructor  // Genera el constructor vacío (necesario para JPA)
@AllArgsConstructor
@Table(name = "mascotas")
public class MascotaEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "cliente_id", nullable = false)
        private Long clienteId;

        @Column(nullable = false, length = 120)
        private String nombre;

        @Column(nullable = false, length = 60)
        private String tipo;

        @Column(nullable = false, length = 80)
        private String raza;

        @Column(name = "edad_anios")
        private Integer edadAnios;

        @Column(name = "edad_meses")
        private Integer edadMeses;

        @Column(name = "foto_url", columnDefinition = "TEXT")
        private String fotoUrl;
    }


