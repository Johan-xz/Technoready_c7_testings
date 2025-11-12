const attractionsService = require('../src/services/attractionsService');
const { calculateDistanceKm } = require('../../common-utils/src/geoUtils');

describe('attractionsService.findNearbyAttractions', () => {
  test('devuelve nodos y distancias desde coordenadas dadas', () => {
    const result = attractionsService.findNearbyAttractions(25.6866, -100.3161);

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