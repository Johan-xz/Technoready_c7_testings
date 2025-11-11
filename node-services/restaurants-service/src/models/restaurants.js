const restaurants = [
  { label: 'La Casona', cuisine: 'Mexicana', lat: 25.7000, lng: -100.3100 },
  { label: 'Il Forno', cuisine: 'Italiana', lat: 25.6700, lng: -100.4000 },
  { label: 'Sushi Zen', cuisine: 'Japonesa', lat: 25.7800, lng: -100.2000 }
];

exports.getNodes = () => restaurants;