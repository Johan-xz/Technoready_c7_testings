const cities = require('../models/cities');
const { calculateDistanceKm } = require('common-utils/src/geoUtils');
exports.findNearbyCities = (lat, lng) => {
  const origin = { lat, lng };
  const nodes = cities.getNodes();
  const edges = nodes.map(node => ({
    from: 'origin',
    to: node.label,
    distanceKm: calculateDistanceKm(lat, lng, node.lat, node.lng)
  }));

  return { origin, nodes, edges };
};