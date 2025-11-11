const request = require('supertest');
const express = require('express');
const routes = require('../src/routes/restaurantsRoutes');

const app = express();
app.use(express.json());
app.use('/', routes);

describe('GET /nearby-restaurants', () => {
  test('devuelve JSON con nodos y edges', async () => {
    const res = await request(app).get('/nearby-restaurants?lat=25.6866&lng=-100.3161');

    expect(res.statusCode).toBe(200);
    expect(res.body).toHaveProperty('nodes');
    expect(res.body).toHaveProperty('edges');
    expect(res.body.nodes.length).toBeGreaterThan(0);
  });

  test('devuelve error si faltan parámetros', async () => {
    const res = await request(app).get('/nearby-restaurants');
    expect(res.statusCode).toBe(400);
    expect(res.body).toHaveProperty('error');
  });
});