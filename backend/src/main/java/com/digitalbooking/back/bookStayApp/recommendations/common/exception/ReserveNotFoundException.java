package com.digitalbooking.back.bookStayApp.recommendations.common.exception;

/**
 * Se lanza cuando no se encuentra una reserva con el ID proporcionado.
 */
public class ReserveNotFoundException extends RecommendationException {
    public ReserveNotFoundException(Long reserveId) {
        super("Reserva no encontrada: ID=" + reserveId);
    }
}