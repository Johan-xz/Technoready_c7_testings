package com.digitalbooking.back.bookStayApp.recommendations.restaurants.domain;

import java.util.Objects;

/**
 * Entidad de dominio que representa un restaurante cercano recomendado.
 */
public class Restaurant {

    private String name;
    private String cuisineType;   // Ej: mexicana, italiana, japonesa
    private double latitude;
    private double longitude;
    private double distanceKm;
    private double rating;        // opcional, si se obtiene de Google Places
    private String priceLevel;    // opcional: $, $$, $$$

    public Restaurant(String name, String cuisineType, double latitude, double longitude,
                      double distanceKm, double rating, String priceLevel) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceKm = distanceKm;
        this.rating = rating;
        this.priceLevel = priceLevel;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCuisineType() {
        return cuisineType;
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

    public double getRating() {
        return rating;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
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
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distanceKm=" + distanceKm +
                ", rating=" + rating +
                ", priceLevel='" + priceLevel + '\'' +
                '}';
    }
}