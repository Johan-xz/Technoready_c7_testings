package com.digitalbooking.back.bookStayApp.recommendations.attractions.controller;

import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.service.AttractionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations/attractions")
public class AttractionController {

    private final AttractionService attractionsService;

    public AttractionController(AttractionService attractionsService) {
        this.attractionsService = attractionsService;
    }

    /**
     * Endpoint para obtener atracciones turísticas cercanas a unas coordenadas específicas.
     * Ejemplo: GET /api/recommendations/attractions?lat=25.6866&lng=-100.3161
     */
    @GetMapping
    public List<AttractionDTO> getAttractionsByCoordinates(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        return attractionsService.getNearbyAttractions(lat, lng);
    }

    /**
     * Endpoint para obtener atracciones turísticas cercanas a partir de una reserva.
     * Ejemplo: GET /api/recommendations/reserves/{reserveId}/attractions
     */
    @GetMapping("/reserves/{reserveId}")
    public List<AttractionDTO> getAttractionsByReserve(@PathVariable Long reserveId) {
        // Aquí deberías obtener las coordenadas del destino desde tu dominio de reservas.
        // Ejemplo simplificado:
        double destLat = 25.6866; // Coordenadas simuladas
        double destLng = -100.3161;
        return attractionsService.getNearbyAttractions(destLat, destLng);
    }
}