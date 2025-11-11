package com.digitalbooking.back.bookStayApp.recommendations.nearbycities.domain;

import java.util.Objects;

/**
 * Entidad de dominio que representa una ciudad cercana al destino del cliente.
 * No es una entidad JPA por defecto, pero puedes anotarla con @Entity si decides persistirla.
 */
public class NearbyCity {

    private String name;
    private double latitude;
    private double longitude;
    private double distanceKm;

    public NearbyCity(String name, double latitude, double longitude, double distanceKm) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceKm = distanceKm;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    // Setters (opcional si quieres inmutabilidad)
    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // equals y hashCode para comparar objetos NearbyCity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NearbyCity)) return false;
        NearbyCity that = (NearbyCity) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "NearbyCity{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distanceKm=" + distanceKm +
                '}';
    }
}