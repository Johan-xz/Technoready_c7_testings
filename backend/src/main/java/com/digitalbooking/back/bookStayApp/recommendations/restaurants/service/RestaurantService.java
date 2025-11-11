package com.digitalbooking.back.bookStayApp.recommendations.restaurants.service;

import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que obtiene restaurantes recomendados cercanos a un destino.
 * En esta versión base, devuelve datos simulados.
 */
@Service
public class RestaurantService {

    /**
     * Obtiene restaurantes cercanos a unas coordenadas.
     * @param lat latitud del destino
     * @param lng longitud del destino
     * @return lista de RestaurantDTO
     */
    public List<RestaurantDTO> getNearbyRestaurants(double lat, double lng) {
        // Simulación de datos. En producción, puedes integrar Google Places API aquí.
        return List.of(
                new RestaurantDTO("La Casona", "Mexicana", lat + 0.01, lng + 0.01, 1.1, 4.6, "$$"),
                new RestaurantDTO("Il Forno", "Italiana", lat - 0.02, lng + 0.02, 2.3, 4.4, "$$$"),
                new RestaurantDTO("Sushi Zen", "Japonesa", lat + 0.03, lng - 0.01, 3.0, 4.7, "$$")
        );
    }
}