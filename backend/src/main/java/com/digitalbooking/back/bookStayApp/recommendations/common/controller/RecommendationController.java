package com.digitalbooking.back.bookStayApp.recommendations.common.controller;

import com.digitalbooking.back.bookStayApp.recommendations.common.dto.RecommendationResponse;
import com.digitalbooking.back.bookStayApp.recommendations.common.service.RecommendationAggregatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationAggregatorService aggregatorService;

    public RecommendationController(RecommendationAggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    /**
     * Endpoint general para obtener todas las recomendaciones agrupadas.
     * Ejemplo: GET /api/recommendations?lat=25.6866&lng=-100.3161
     */
    @GetMapping
    public RecommendationResponse getRecommendations(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        return aggregatorService.getRecommendations(lat, lng);
    }

    /**
     * Endpoint alternativo para obtener recomendaciones a partir de una reserva.
     * Ejemplo: GET /api/recommendations/reserves/{reserveId}
     */
    @GetMapping("/reserves/{reserveId}")
    public RecommendationResponse getRecommendationsByReserve(@PathVariable Long reserveId) {
        // Aquí deberías consultar el módulo de reservas para obtener coordenadas reales.
        double destLat = 25.6866; // Simulado
        double destLng = -100.3161;
        return aggregatorService.getRecommendations(destLat, destLng);
    }
}