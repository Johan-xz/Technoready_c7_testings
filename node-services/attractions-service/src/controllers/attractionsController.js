const attractionsService = require('../services/attractionsService');
const { calculateDistanceKm } = require('common-utils/src/geoUtils');

exports.getNearbyAttractions = async (req, res) => {
  const { lat, lng } = req.query;
  if (!lat || !lng) return res.status(400).json({ error: 'Missing coordinates' });

  try {
    const response = await attractionsService.findNearbyAttractions(parseFloat(lat), parseFloat(lng));
    res.json(response);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: 'Internal server error' });
  }
};