package com.medipets.usmascota.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RazaService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<String> obtenerRazasPorTipo(String tipo) {

        List<String> razas = new ArrayList<>();

        if (tipo.equalsIgnoreCase("perro")) {
            String url = "https://api.thedogapi.com/v1/breeds";
            ResponseEntity<List<Map<String, Object>>> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<>() {}
                    );

            for (Map<String, Object> breed : response.getBody()) {
                razas.add((String) breed.get("name"));
            }

        } else if (tipo.equalsIgnoreCase("gato")) {
            String url = "https://api.thecatapi.com/v1/breeds";
            ResponseEntity<List<Map<String, Object>>> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<>() {}
                    );

            for (Map<String, Object> breed : response.getBody()) {
                razas.add((String) breed.get("name"));
            }
        }

        // Regla de negocio común
        razas.add("Mestizo");

        return razas;
    }
}
