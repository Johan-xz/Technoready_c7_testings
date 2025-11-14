// Importa la función desde el módulo compartido
const { calculateDistanceKm } = require('common-utils/src/geoUtils');
const attractions = require('../models/attractions');

exports.findNearbyAttractions = (lat, lng) => {
  const origin = { lat, lng };
  const nodes = attractions.getNodes();

  const edges = nodes.map(node => ({
    from: 'origin',
    to: node.label,
    distanceKm: calculateDistanceKm(lat, lng, node.lat, node.lng)
  }));

  return { origin, nodes, edges };
};