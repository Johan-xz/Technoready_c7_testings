const restaurants = require('../models/restaurants');
const { calculateDistanceKm } = require('common-utils/src/geoUtils');
exports.findNearbyRestaurants = (lat, lng) => {
  const origin = { lat, lng };
  const nodes = restaurants.getNodes();
  const edges = nodes.map(node => ({
    from: 'origin',
    to: node.label,
    distanceKm: calculateDistanceKm(lat, lng, node.lat, node.lng)
  }));

  return { origin, nodes, edges };
};