package com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
/**
 * DTO expuesto por la API para describir una ciudad cercana.
 * Contrato público: se usa en controllers y respuestas JSON.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NearbyCityDTO {

    private String cityName;
    private double latitude;
    private double longitude;
    private double distanceKm;
}