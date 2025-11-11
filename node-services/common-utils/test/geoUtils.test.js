const { calculateDistanceKm } = require('../src/geoUtils');

test('calcula distancia entre dos puntos', () => {
  const dist = calculateDistanceKm(25.6866, -100.3161, 25.7000, -100.3100);
  expect(dist).toBeGreaterThan(1);
  expect(dist).toBeLessThan(3);
});