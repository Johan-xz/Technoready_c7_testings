package com.digitalbooking.back.recommendations.common.service;

import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.service.AttractionService;
import com.digitalbooking.back.bookStayApp.recommendations.common.dto.RecommendationResponse;
import com.digitalbooking.back.bookStayApp.recommendations.common.service.RecommendationAggregatorService;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.service.NearbyCityService;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecommendationAggregatorServiceTest {

    @Mock
    private NearbyCityService nearbyCitiesService;

    @Mock
    private AttractionService attractionsService;

    @Mock
    private RestaurantService restaurantsService;

    @InjectMocks
    private RecommendationAggregatorService aggregatorService;

    @Test
    void shouldAggregateRecommendations() {
        double lat = 25.6866;
        double lng = -100.3161;

        when(nearbyCitiesService.getNearbyCities(lat, lng)).thenReturn(List.of(new NearbyCityDTO("San Pedro", 25.7000, -100.3100, 1.2)));
        when(attractionsService.getNearbyAttractions(lat, lng)).thenReturn(List.of(new AttractionDTO("Museo", "Museo", lat, lng, 1.0, 4.5)));
        when(restaurantsService.getNearbyRestaurants(lat, lng)).thenReturn(List.of(new RestaurantDTO("La Casona", "Mexicana", lat, lng, 1.0, 4.6, "$$")));

        RecommendationResponse response = aggregatorService.getRecommendations(lat, lng);

        assertEquals(1, response.getNearbyCities().size());
        assertEquals(1, response.getAttractions().size());
        assertEquals(1, response.getRestaurants().size());
    }
}