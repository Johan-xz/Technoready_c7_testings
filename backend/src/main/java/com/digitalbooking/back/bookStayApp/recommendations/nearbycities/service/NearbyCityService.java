package com.digitalbooking.back.bookStayApp.recommendations.nearbycities.service;

import com.digitalbooking.back.bookStayApp.recommendations.nearbycities.dto.NearbyCityDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class NearbyCityService {

    private final WebClient webClient;

    public NearbyCityService(WebClient.Builder builder) {
        // URL del microservicio Node.js (puedes configurarla en application.properties)
        this.webClient = builder
                .baseUrl(System.getenv().getOrDefault("NEARBY_SERVICE_URL", "http://localhost:4000"))
                .build();
    }

    /**
     * Obtiene las ciudades cercanas a partir de coordenadas de destino.
     * @param destLat latitud del destino
     * @param destLng longitud del destino
     * @return lista de NearbyCityDTO
     */
    public List<NearbyCityDTO> getNearbyCities(double destLat, double destLng) {
        NearbyResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/nearby-cities")
                        .queryParam("lat", destLat)
                        .queryParam("lng", destLng)
                        .build())
                .retrieve()
                .bodyToMono(NearbyResponse.class)
                .block();

        return response != null ? response.toDTOs() : List.of();
    }

    /**
     * Clase interna para mapear la respuesta JSON del microservicio Node.js.
     */
    public static class NearbyResponse {
        public Origin origin;
        public List<Node> nodes;
        public List<Edge> edges;

        public List<NearbyCityDTO> toDTOs() {
            return nodes.stream().map(n -> {
                var edge = edges.stream()
                        .filter(e -> e.to.equals(n.label))
                        .findFirst()
                        .orElse(null);

                return new NearbyCityDTO(
                        n.label,
                        n.lat,
                        n.lng,
                        edge != null ? edge.distanceKm : Double.NaN
                );
            }).toList();
        }

        public static class Origin {
            public double lat;
            public double lng;
        }

        public static class Node {
            public String label;
            public double lat;
            public double lng;
        }

        public static class Edge {
            public String from;
            public String to;
            public double distanceKm;
        }
    }
}