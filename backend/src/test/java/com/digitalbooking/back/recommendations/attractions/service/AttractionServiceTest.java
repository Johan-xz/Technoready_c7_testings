package com.digitalbooking.back.recommendations.attractions.service;

import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.service.AttractionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AttractionsServiceTest {

    @InjectMocks
    private AttractionService service;

    @Test
    void shouldReturnNearbyAttractions() {
        double lat = 25.6866;
        double lng = -100.3161;

        List<AttractionDTO> result = service.getNearbyAttractions(lat, lng);

        assertFalse(result.isEmpty());
        assertTrue(result.stream().anyMatch(a -> a.getCategory().equals("Museo")));
    }
}