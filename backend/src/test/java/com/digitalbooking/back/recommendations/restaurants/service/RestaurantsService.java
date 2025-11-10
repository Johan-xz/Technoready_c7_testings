package com.digitalbooking.back.recommendations.restaurants.service;


import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RestaurantsServiceTest {

    @InjectMocks
    private RestaurantService service;

    @Test
    void shouldReturnNearbyRestaurants() {
        double lat = 25.6866;
        double lng = -100.3161;

        List<RestaurantDTO> result = service.getNearbyRestaurants(lat, lng);

        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(r -> r.getCuisineType().equals("Mexicana")));
    }
}