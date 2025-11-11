require('dotenv').config();
const express = require('express');
const app = express();
const routes = require('./routes/restaurantsRoutes');

app.use(express.json());
app.use('/', routes);

const PORT = process.env.PORT || 4001;
app.listen(PORT, () => console.log(`Restaurants service running on port ${PORT}`));