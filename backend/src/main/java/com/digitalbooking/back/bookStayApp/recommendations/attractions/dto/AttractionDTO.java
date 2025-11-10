package com.digitalbooking.back.bookStayApp.recommendations.attractions.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * DTO expuesto por la API para describir una atracción turística cercana.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttractionDTO {

    private String name;
    private String category;     // Ej: museo, parque, sitio histórico
    private double latitude;
    private double longitude;
    private double distanceKm;
    private double rating;       // opcional, si se obtiene de Google Places
}