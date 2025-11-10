package com.digitalbooking.back.recommendations.nearbycities.service;

import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.service.NearbyCityService;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestNearbyCitiesService {

    @InjectMocks
    private NearbyCityService service;

    @Test
    void shouldReturnNearbyCities() {
        double lat = 25.6866;
        double lng = -100.3161;

        List<NearbyCityDTO> result = service.getNearbyCities(lat, lng);

        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(c -> c.getCityName().equals("San Pedro")));
    }
}