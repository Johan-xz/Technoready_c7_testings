const express = require('express');
const router = express.Router();
const controller = require('../controllers/nearbyCitiesController');

router.get('/nearby-cities', controller.getNearbyCities);

module.exports = router;