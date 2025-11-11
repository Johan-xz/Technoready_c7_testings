require('dotenv').config();
const express = require('express');
const app = express();
const routes = require('./routes/nearbyCitiesRoutes');

app.use(express.json());
app.use('/', routes);

const PORT = process.env.PORT || 4000;
app.listen(PORT, () => console.log(`Nearby service running on port ${PORT}`));