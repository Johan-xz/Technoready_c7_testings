package com.digitalbooking.back.bookStayApp.recommendations.common.dto;

import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto.RestaurantDTO;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResponse {
    private List<NearbyCityDTO> nearbyCities;
    private List<AttractionDTO> attractions;
    private List<RestaurantDTO> restaurants;
}