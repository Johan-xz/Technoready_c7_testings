package com.digitalbooking.back.bookStayApp.recommendations.common.exception;

/**
 * Se lanza cuando las coordenadas proporcionadas son inválidas.
 */
public class InvalidCoordinatesException extends RecommendationException {
    public InvalidCoordinatesException(double lat, double lng) {
        super("Coordenadas inválidas: lat=" + lat + ", lng=" + lng);
    }
}