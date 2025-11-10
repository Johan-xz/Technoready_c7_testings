package com.digitalbooking.back.bookStayApp.recommendations.common.exception;

/**
 * Se lanza cuando falla la comunicación con un servicio externo (ej. Google Places, Node.js).
 */
public class ExternalServiceException extends RecommendationException {
    public ExternalServiceException(String serviceName, Throwable cause) {
        super("Error al comunicarse con el servicio externo: " + serviceName, cause);
    }
}