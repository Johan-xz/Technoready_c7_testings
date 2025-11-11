package com.digitalbooking.back.bookStayApp.recommendations.restaurants.controller;

import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantsService;

    public RestaurantController(RestaurantService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    /**
     * Endpoint para obtener restaurantes cercanos a unas coordenadas específicas.
     * Ejemplo: GET /api/recommendations/restaurants?lat=25.6866&lng=-100.3161
     */
    @GetMapping
    public List<RestaurantDTO> getRestaurantsByCoordinates(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        return restaurantsService.getNearbyRestaurants(lat, lng);
    }

    /**
     * Endpoint para obtener restaurantes cercanos a partir de una reserva.
     * Ejemplo: GET /api/recommendations/reserves/{reserveId}/restaurants
     */
    @GetMapping("/reserves/{reserveId}")
    public List<RestaurantDTO> getRestaurantsByReserve(@PathVariable Long reserveId) {
        // Aquí deberías obtener las coordenadas del destino desde tu dominio de reservas.
        // Ejemplo simplificado:
        double destLat = 25.6866; // Coordenadas simuladas
        double destLng = -100.3161;
        return restaurantsService.getNearbyRestaurants(destLat, destLng);
    }
}