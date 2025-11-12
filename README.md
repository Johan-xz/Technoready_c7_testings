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

[Ver mi PDF](https://github.com/TU_USUARIO/TU_REPO/raw/main/ruta/tu_archivo.pdf)

## 🏛️ Architecture
The backend is designed using Domain-Driven Design (DDD) principles, organizing the application into distinct submodules or "bounded contexts." This approach promotes a clean architecture, making the system scalable, maintainable, and closely aligned with the business logic.

## High-Level Design

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
🚀 Sprint 2 – Graph Visualization Testing & Repository Update


### 🎯 Objectives
This sprint focused on implementing a robust testing strategy for the graph visualization module in JavaScript, which displays nearby cities and their distances. The goal was to ensure high reliability, resilience to edge cases, and maintainability through automated unit testing with Jest.

### 🧪 Testing Strategy with Jest
- ✅ Environment Setup
    - Configured Jest for JavaScript testing using Babel and ES modules.

    - Added jest.config.js and necessary scripts to package.json.

    - Ensured compatibility with the graph module and DOM mocking via jsdom.

- 🧩 Test Design & Equivalence Classes
    - Designed equivalence classes covering:

        - Valid city-distance pairs

        - Empty datasets

        - Malformed or inconsistent data

        - Unexpected input types (e.g., null, undefined, strings instead of numbers)

    - Boundary cases included:

        - Maximum distance thresholds

        - Cities with no neighbors

        - Circular references

    - 🧬 Test Cases
Implemented over 30 unit tests covering:

        - Graph rendering logic

        - Distance calculation accuracy

        - Error handling and fallback behavior

        - DOM updates and data binding

Used mocking and spies to isolate logic and simulate external data sources.

- 📊 Coverage Report
Achieved 92.7% overall coverage:

        - Statements: 93%

        - Branches: 89%

        - Functions: 94%

        - Lines: 92%

Coverage screenshots are included in /docs/coverage-report/.

🧠 Technical Reflection
A detailed file testing-reflection.md documents:

        - Main challenges (e.g., mocking asynchronous data, handling edge cases)

        - Strategies used (e.g., dependency injection, modularization)

        - Lessons learned and improvements for future testing cycles

🔍 Peer Review
A cross-review was conducted with Johan Gloria to validate:

        - Clarity of test descriptions

        - Naming conventions

        - Coverage relevance

        - Suggestions for improving modularity and reusability

- 📁 GitHub Repository Update
All deliverables for Sprint 2 have been committed and pushed to the main repository:

## 🔄 Changes Included
- /graph/__tests__/graph.test.js – Unit tests

- /graph/graph.js – Refactored graph logic for testability

- /docs/coverage-report/ – Coverage screenshots

- /docs/testing-reflection.md – Technical documentation

- Updated README.md with Sprint 2 summary

- Tagged release v2.0-sprint2 for traceability


## 🧠 Impact & Innovation

| **Dimension**                                   | **Contribution** |
|-------------------------------------------------|------------------|
| **Knowledge Integration**                       | Developed a strategic testing framework aligned with operational goals and resilience requirements. |
| **Equivalence Class Design**                    | Led the creation of comprehensive equivalence classes, optimizing for edge cases and real-world data inconsistencies. |
| **Test Case Design**                            | Delivered innovative and scalable test cases that anticipate future module extensions. |
| **JavaScript Simulation**                       | Refactored the graph module to support simulation and testing, applying advanced JS patterns. |
| **Innovation Strategy**                         | Introduced a modular testing architecture and peer review loop to elevate code quality. |
| **Visual Narrative & Impact**                   | Documented testing impact through coverage visuals and stakeholder-oriented reflections. |
| **Leadership & Communication**                  | Demonstrated strategic leadership in testing, documentation, and repository management. |



## 🧭 Next Steps
- Extend testing to other visualization modules (e.g., attractions, restaurants).

- Integrate CI/CD pipeline with Jest and coverage thresholds.

- Explore mutation testing to further validate test robustness.

### 📦 Sprint 3 – Documentation, Testing & Architecture Diagrams

## 🧭 General Project Description
This project is a modular travel recommendation system that integrates data from external APIs (Google Maps, INEGI, Datatur) to suggest attractions, restaurants, and nearby cities. It includes:

- Reservations Module: Allows users to book experiences and manage itineraries.

- City Graph Visualization: Displays nearby cities and distances using a graph-based interface.

- Offer Management: Sellers can create and publish promotional offers.
- Public Catalog: Shoppers can browse available items and view detailed information.

The backend follows Domain-Driven Design (DDD) principles, ensuring scalability and maintainability.

### ⚙️ Installation Instructions

1. Clone the Repository
````
git clone https://github.com/your-org/travel-recommendation-system.git
cd travel-recommendation-system
````
2. Install Dependencies
Java Backend
- Requires Java 17+ and Maven

````
mvn clean install
````
JavaScript Frontend & Testing
- Requires Node.js 18+

````
npm install
````
3. Run the Project
Backend
````
mvn spring-boot:run
````
Frontend
````
npm start
````
🧪 Unit Tests Overview
✅ Sprint 1 – Java Backend
- Module: Error handling and API resilience

- Tool: JUnit

- Tests: Validate exception propagation, custom error messages, and fallback logic

- Execution:
````
mvn test
````
✅ Sprint 2 – JavaScript Graph Module
- Module: Nearby cities graph visualization
- Tool: Jest

- Tests:

    - Valid city-distance rendering

    - Edge cases (empty data, malformed input)

    - Error handling and DOM updates

- Execution:
````
npm test
````
Coverage Example
````
npm test -- --coverage
````
📦 Coverage by Class/Package
| Metric                         | Estimated Value |
|--------------------------------|-----------------|
| **Total instruction coverage** | **13%** ✅      |
| Classes analyzed               | 2               |
| Methods covered                | Partial         |
| Conditional branches covered   | Mostly missing  |
| Line coverage                  | Low             |

Our current test coverage is approximately 13%, based on the JaCoCo report. This means only a small portion of your code is being executed by your test suite. This is typical in early testing stages or when tests are focused on a limited set of classes. That's why we workn on improve Coverage:
To reach our goal of 90% coverage:

✅ Write unit tests for each service class

✅ Use Mockito to mock dependencies

✅ Test both success and failure scenarios (invalid inputs, exceptions)

✅ Cover all conditional paths and validations

Expected output:
PASS  graph/__tests__/graph.test.js
✓ renders valid graph nodes
✓ handles empty input gracefully
✓ throws error on malformed data

Coverage summary:
Statements   : 93.00%
Branches     : 89.00%
Functions    : 94.00%
Lines        : 92.00%


🔍 Review & Adjustment
✅ All modules reviewed for documentation completeness

✅ Diagrams updated and exported to PDF

✅ Repository access configured for the Digital NAO team

✅ Code comments standardized across Java and JavaScript

✅ README files updated for each sprint


🧩 Diagrams
Architecture diagrams are available in /docs/diagrams/ and include: 

📐 Class Diagram (Java backend)

🔄 Flowchart of data aggregation and recommendation logic

🔗 Module Interaction Diagram (Frontend ↔ Backend ↔ External APIs)

All diagrams are delivered in PDF format for easy sharing and review.