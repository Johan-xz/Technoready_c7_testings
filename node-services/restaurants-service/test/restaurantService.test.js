const restaurantsService = require('../src/services/restaurantsService');

describe('restaurantsService.findNearbyRestaurants', () => {
  test('devuelve nodos y distancias desde coordenadas dadas', () => {
    const result = restaurantsService.findNearbyRestaurants(25.6866, -100.3161);

    expect(result).toHaveProperty('origin');
    expect(result.origin).toEqual({ lat: 25.6866, lng: -100.3161 });

    expect(result).toHaveProperty('nodes');
    expect(Array.isArray(result.nodes)).toBe(true);
    expect(result.nodes.length).toBeGreaterThan(0);

    expect(result).toHaveProperty('edges');
    expect(Array.isArray(result.edges)).toBe(true);
    expect(result.edges[0]).toHaveProperty('distanceKm');
    expect(result.edges[0].distanceKm).toBeGreaterThan(0);
  });
});