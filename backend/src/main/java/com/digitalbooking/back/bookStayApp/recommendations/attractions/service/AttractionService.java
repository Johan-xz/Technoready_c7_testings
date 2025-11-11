package com.digitalbooking.back.bookStayApp.recommendations.attractions.service;

import com.digitalbooking.back.bookStayApp.recommendations.attractions.dto.AttractionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que obtiene atracciones turísticas cercanas a un destino.
 * En esta versión base, devuelve datos simulados.
 */
@Service
public class AttractionService {

    /**
     * Obtiene atracciones cercanas a unas coordenadas.
     * @param lat latitud del destino
     * @param lng longitud del destino
     * @return lista de AttractionDTO
     */
    public List<AttractionDTO> getNearbyAttractions(double lat, double lng) {
        // Simulación de datos. En producción, puedes integrar Google Places API aquí.
        return List.of(
                new AttractionDTO("Museo de Historia", "Museo", lat + 0.01, lng + 0.01, 1.2, 4.5),
                new AttractionDTO("Parque Fundidora", "Parque", lat + 0.02, lng - 0.01, 2.8, 4.7),
                new AttractionDTO("Catedral Metropolitana", "Sitio histórico", lat - 0.01, lng + 0.02, 3.1, 4.6)
        );
    }
}