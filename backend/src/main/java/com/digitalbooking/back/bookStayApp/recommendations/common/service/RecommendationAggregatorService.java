package com.digitalbooking.back.bookStayApp.recommendations.common.service;

import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.service.NearbyCityService;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.service.AttractionService;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.service.RestaurantService;
import com.digitalbooking.back.bookStayApp.recommendations.common.dto.RecommendationResponse;
import org.springframework.stereotype.Service;

@Service
public class RecommendationAggregatorService {

    private final NearbyCityService nearbyCitiesService;
    private final AttractionService attractionsService;
    private final RestaurantService restaurantsService;

    public RecommendationAggregatorService(
            NearbyCityService nearbyCitiesService,
            AttractionService attractionsService,
            RestaurantService restaurantsService
    ) {
        this.nearbyCitiesService = nearbyCitiesService;
        this.attractionsService = attractionsService;
        this.restaurantsService = restaurantsService;
    }

    /**
     * Orquesta las recomendaciones a partir de coordenadas de destino.
     * @param lat latitud del destino
     * @param lng longitud del destino
     * @return objeto RecommendationResponse con todas las recomendaciones agrupadas
     */
    public RecommendationResponse getRecommendations(double lat, double lng) {
        var nearbyCities = nearbyCitiesService.getNearbyCities(lat, lng);
        var attractions = attractionsService.getNearbyAttractions(lat, lng);
        var restaurants = restaurantsService.getNearbyRestaurants(lat, lng);

        return new RecommendationResponse(nearbyCities, attractions, restaurants);
    }
}