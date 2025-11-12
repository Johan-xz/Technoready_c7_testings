# 🏨 Hotel Reservation App | Backend software

⚠️ This repository only contains information about the backend. If you wish to access the complete project, send me a message.
  
Digital Booking is a hotel reservation platform focused on user-friendly experience and efficient business management. The backend adheres to SOLID principles and Domain Driven Design, using Java, Spring Boot, Hibernate, and SQL. This repository features a scalable and clean backend solution for managing hotel reservations, built with Java 17, Maven, Spring Boot 3.0, and Hibernate.

Visit the [project's wiki 📚](https://github.com/florencialecha/digital-booking-software-backend/wiki) for detailed documentation.

[🖥️ View Live Demo](http://digital-booking-6.s3-website.us-east-2.amazonaws.com/) |
[📃 API Documentation](http://3.131.138.206:8080/swagger-ui/index.html#/)

<img src="https://user-images.githubusercontent.com/106263642/232561907-ca963573-41f6-44d1-bc40-4520aca7ecd2.gif">

## 📚 Table of Contents
 
1. [🌟 Features](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#-features)
2. [🎯 Overview](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#--overview)
3. [💻 Technologies](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#-technologies)
4. [⚙️ Setup](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#%EF%B8%8F-setup)
5. [🚀 Usage](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#-usage)
7. [📃 API Documentation](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#-api-documentation)
8. [👩‍💻 About the Developer](https://github.com/florencialecha/digital-booking-software-backend/blob/development/README.md#-about-the-developer)



## 🌟 Features

- User registration and authentication
- Browse and search for available hotels
- Book and manage reservations
- Admin panel for hotel management
- Clean and maintainable code

## 🎯  Overview

📚 For 8️⃣ weeks, my 4️⃣ teammates and I immersed ourselves in the adventure 🚀 of developing our first application from start 🏁 to finish, completely from scratch.
🔍In this repository, you will find the application's backend software created by Florencia Lecha, along with details on why each technical decision was made and how the focus was kept on essential aspects:
- **Keep it simple and functional:** 🏆 MVP always working with constant increments. 
- **Taking care of the basics:** ✅ Good practices, code readability, clean architectures that make the business logic explicit.
- **Easily scalable and maintainable** without over-engineering (probably the most difficult challenge)🌟.
- **Have fun and improve:** 🔑 key to face the challenges we faced.

🎯We achieved a robust hotel booking platform 🏨 with a focus on creating a user-friendly experience and efficient business management.
In addition to this, we achieved a **solid and clean backend, following SOLID and Domain Driven Design principles** as well as a **unified frontend** at the style level and consistent at the code level and a continuous integration pipline that made it very easy for us to implement features.

Feel free to explore the [project's wiki](https://github.com/florencialecha/digital-booking-software-backend/wiki) for a deeper understanding of the development process and the decisions made throughout the creation of this hotel reservation application.

## 💻 Technologies

- **Java 17**
- **Spring Boot 3.0**
- **Hibernate**
- **Maven**
- **Spring Security 6.0**
- **JUnit**
- **SQL**
- **MySQL**
- **Lombok**
- **Swagger**
- **ModelMapper**
- **Spring Boot Starter Security**
- **Commons Validator**
- **Hibernate Validator**
- **JSON Web Token (JWT)**

## ⚙️ Setup
1. Clone the repository
2. Install Java 17 and Maven
3. Configure MySQL database
4. Update application.properties with database credentials
5. Build the project using Maven: mvn clean install
6. Run the application: mvn spring-boot:run

## 🚀 Usage
Once the application is running, access the Swagger UI at http://localhost:8080/swagger-ui.html to view and test the available API endpoints.

## 📃 API Documentation

View the API documentation at [http://3.131.138.206:8080/swagger-ui/index.html#/](http://3.131.138.206:8080/swagger-ui/index.html#/)

## 👥 Squad
* **Damian Dell'Acqua -** Front-End Developer 💻
* **Rocky Montero -** Front-End Developer 💻
* **Manuel Godoy -** Testing 🧪
* **Ciro Rojas -** Infrastructure 🏗️
* **Florencia Lecha -** Back-End Developer 🔧

## 👩‍💻 About the Backend Developer

Hi, I'm [Florencia](https://www.linkedin.com/in/florencialecha/), the developer of this project. I'm a full-stack programmer with a strong focus on backend development. My passion lies in creating clean, maintainable, and efficient software architectures, following best practices like Domain-Driven Design (DDD) and SOLID principles. I continuously strive to enhance my skills and deliver high-quality solutions that meet both business and user needs.

Feel free to connect with me on [LinkedIn](https://www.linkedin.com/in/florencialecha/) or check out my [GitHub](https://github.com/florencialecha) for more projects.

---
# Update Java and JavaScript. Programming Procedures By:
* **Johan Gloria  -** Full-stack Developer
* **Sofía Guzmán  -** Testing 🧪

## 🏛️ Architecture
The backend is designed using Domain-Driven Design (DDD) principles, organizing the application into distinct submodules or "bounded contexts." This approach promotes a clean architecture, making the system scalable, maintainable, and closely aligned with the business logic.

## High-Level Design
![diagram DDD](images/diagram%20DDD.jpeg)
As shown in the diagram, the system is divided into an Internal System and an External Aggregator. Recommendations:
- AggregatorService (External): Acts as the primary entry point (Facade) for travel recommendations. It coordinates requests and aggregates data from various internal services to provide a complete response to the client.

- Internal System: Contains the core business logic, separated into modules:

- Atracciones (Attractions)

- Restaurants

- NearbyCities

- External APIs: The internal services consume external APIs to enrich the data:

- Google Maps: Provides data on nearby places and distances.

- INEGI: Provides tourism indicators.

- Datatur (SECTUR): Provides information on most-visited locations.

## Package Structure (by Feature)
This DDD approach is reflected in the project's package structure, where each core domain has its own dedicated folder. This isolates domain logic, services, and controllers, keeping the concerns of each module separate.

````
com/digitalbooking
└── recommendations
│
├── attractions
│   ├── controller
│   │   └── AttractionController.java
│   ├── domain
│   │   └── Attraction.java
│   ├── dto
│   │   └── AttractionDTO.java
│   └── service
│       └── AttractionService.java
│
├── nearbycities
│   ├── controller
│   │   └── NearbyCityController.java
│   ├── domain
│   │   └── NearbyCity.java
│   ├── dto
│   │   └── NearbyCityDTO.java
│   └── service
│       └── NearbyCityService.java
│
├── restaurants
│   ├── controller
│   │   └── RestaurantController.java
│   ├── domain
│   │   └── Restaurant.java
│   ├── dto
│   │   └── RestaurantDTO.java
│   └── service
│       └── RestaurantService.java
│
├── reserves
│   └── ... (structure follows domain pattern)
│
└── common
├── controller
│   └── RecommendationController.java (uses the aggregator)
├── service
│   └── RecommendationAggregatorService.java
├── dto
│   └── RecommendationResponse.java
└── exception
├── ExternalServiceException.java
├── InvalidCoordinatesException.java
└── ...
````

## Sprint 2
Working on...


## Rationale for Node.js microservices

This project uses independent microservices built with Node.js and Express to encapsulate geospatial recommendation logic for nearby cities, restaurants, and attractions. Each service is lightweight, testable with Jest, and can scale horizontally. Shared geospatial utilities (e.g., Haversine distance) live in a common module to avoid duplication and simplify maintenance.

- **Decoupling:** Each domain (cities, restaurants, attractions) evolves and deploys independently.
- **Performance:** Node.js suits I/O-bound HTTP workloads and efficient computation.
- **Reuse:** Shared logic centralized in a common-utils package.
- **Scalability:** Services scale individually based on demand.
- **Testability:** Per-service Jest suites integrate cleanly with CI/CD.

---

## Installation and local development

```bash
# Clone a service
git clone https://github.com/your-org/nearby-service.git
cd nearby-service

# Install dependencies
npm install

# Run the service
npm start

# Run tests
npm test
```

- **Environment:** Create a `.env` file per service with its port.
  - Nearby: `PORT=4000`
  - Restaurants: `PORT=4001`
  - Attractions: `PORT=4002`
- **Shared utilities:** If using a local common package, ensure it’s available either via relative path (e.g., `../../common-utils/src/geoUtils`) or installed as a local package (e.g., `npm install ../common-utils` and import by name).

---

## API endpoints

### Nearby-service endpoints

| Method | Endpoint         | Description                                  | Example query                                      |
|-------|-------------------|----------------------------------------------|----------------------------------------------------|
| GET   | /nearby-cities    | Returns nearby cities with computed distances | /nearby-cities?lat=25.6866&lng=-100.3161           |

> Sources:

#### Example response
```json
{
  "origin": { "lat": 25.6866, "lng": -100.3161 },
  "nodes": [
    { "label": "San Pedro", "lat": 25.7000, "lng": -100.3100 }
  ],
  "edges": [
    { "from": "origin", "to": "San Pedro", "distanceKm": 1.5 }
  ]
}
```

---

### Restaurants-service endpoints

| Method | Endpoint             | Description                                        | Example query                                          |
|-------|-----------------------|----------------------------------------------------|--------------------------------------------------------|
| GET   | /nearby-restaurants   | Returns nearby restaurants with computed distances | /nearby-restaurants?lat=25.6866&lng=-100.3161          |

> Sources:

#### Example response
```json
{
  "origin": { "lat": 25.6866, "lng": -100.3161 },
  "nodes": [
    { "label": "La Casona", "cuisine": "Mexican", "lat": 25.7000, "lng": -100.3100 }
  ],
  "edges": [
    { "from": "origin", "to": "La Casona", "distanceKm": 1.2 }
  ]
}
```

---

### Attractions-service endpoints

| Method | Endpoint            | Description                                         | Example query                                         |
|-------|----------------------|-----------------------------------------------------|-------------------------------------------------------|
| GET   | /nearby-attractions  | Returns nearby attractions with computed distances  | /nearby-attractions?lat=25.6866&lng=-100.3161         |

> Sources:

#### Example response
```json
{
  "origin": { "lat": 25.6866, "lng": -100.3161 },
  "nodes": [
    { "label": "Parque Fundidora", "category": "Park", "lat": 25.6800, "lng": -100.2900 }
  ],
  "edges": [
    { "from": "origin", "to": "Parque Fundidora", "distanceKm": 3.0 }
  ]
}
```

---

## Notes for integration

- **Query parameters:** All endpoints require lat and lng as query parameters; respond with 400 if missing.
- **Response shape:** Consistent across services with origin, nodes, and edges; edges include distanceKm calculated via common-utils.
- **Java integration:** Configure a WebClient per service with its base URL; compose aggregated responses in your Java layer if needed.
