package com.digitalbooking.back.bookStayApp.recommendations.nearbycities.controller;

import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.domain.NearbyCity;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.service.NearbyCityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations/nearby-cities")
public class NearbyCityController {

    private final NearbyCityService nearbyCitiesService;

    public NearbyCityController(NearbyCityService nearbyCitiesService) {
        this.nearbyCitiesService = nearbyCitiesService;
    }

    /**
     * Endpoint para obtener ciudades cercanas a unas coordenadas específicas.
     * Ejemplo: GET /api/recommendations/nearby-cities?lat=25.6866&lng=-100.3161
     */
    @GetMapping
    public List<NearbyCityDTO> getNearbyCities(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        return nearbyCitiesService.getNearbyCities(lat, lng);
    }

    /**
     * Endpoint para obtener ciudades cercanas a partir de una reserva.
     * Ejemplo: GET /api/recommendations/reserves/{reserveId}/nearby-cities
     */
    @GetMapping("/reserves/{reserveId}")
    public List<NearbyCityDTO> getNearbyCitiesByReserve(@PathVariable Long reserveId) {
        // Aquí deberías obtener las coordenadas del destino desde tu dominio de reservas.
        // Ejemplo simplificado:
        double destLat = 25.6866; // Monterrey
        double destLng = -100.3161;
        return nearbyCitiesService.getNearbyCities(destLat, destLng);
    }
}