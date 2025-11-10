package com.digitalbooking.back.bookStayApp.recommendations.restaurants.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * DTO expuesto por la API para describir un restaurante cercano recomendado.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    private String name;
    private String cuisineType;   // Ej: mexicana, italiana, japonesa
    private double latitude;
    private double longitude;
    private double distanceKm;
    private double rating;        // opcional, si se obtiene de Google Places
    private String priceLevel;    // opcional: $, $$, $$$
}