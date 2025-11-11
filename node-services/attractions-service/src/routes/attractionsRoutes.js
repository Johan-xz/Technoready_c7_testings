const express = require('express');
const router = express.Router();
const controller = require('../controllers/attractionsController');

router.get('/nearby-attractions', controller.getNearbyAttractions);

module.exports = router;