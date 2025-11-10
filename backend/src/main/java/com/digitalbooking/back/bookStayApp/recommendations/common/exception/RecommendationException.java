package com.digitalbooking.back.bookStayApp.recommendations.common.exception;

/**
 * Excepción base para todas las recomendaciones.
 */
public class RecommendationException extends RuntimeException {
    public RecommendationException(String message) {
        super(message);
    }

    public RecommendationException(String message, Throwable cause) {
        super(message, cause);
    }
}