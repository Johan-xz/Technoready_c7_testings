require('dotenv').config();
const express = require('express');
const app = express();
const routes = require('./routes/attractionsRoutes');

app.use(express.json());
app.use('/', routes);

const PORT = process.env.PORT || 4002;
app.listen(PORT, () => console.log(`Attractions service running on port ${PORT}`));