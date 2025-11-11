const express = require('express');
const router = express.Router();
const controller = require('../controllers/restaurantsController');

router.get('/nearby-restaurants', controller.getNearbyRestaurants);

module.exports = router;