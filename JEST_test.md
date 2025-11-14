# Jest Testing Issues - Resolution Report

## Overview
This document details all the Jest testing failures encountered in the Node.js services and the solutions implemented to resolve them.

---

## Project Structure
```
node-services/
├── attractions-service/
├── restaurants-service/
├── nearby-service/
└── common-utils/
```

---

## Issues Found and Resolved

### 1. **Attractions Service** 
#### Issues:
- **Import Error - Case Sensitivity**: In `src/controllers/attractionsController.js`, the import statement had an incorrect function name:
  ```javascript
  // WRONG
  const { calculateDistancekm } = require('../../common-utils/src/geoUtils');
  
  // CORRECT
  const { calculateDistanceKm } = require('common-utils/src/geoUtils');
  ```
  - The function name was `calculateDistanceKm` (with capital 'K'), but was imported as `calculateDistancekm` (lowercase 'k')

- **Module Resolution Error**: The relative path `../../common-utils/src/geoUtils` was not being resolved correctly by Jest
  - Solution: Changed to use the installed module reference `common-utils/src/geoUtils`

- **Mixed Import Syntax**: In `test/attractionsService.test.js`, there was a mix of ES6 import syntax and CommonJS require:
  ```javascript
  // WRONG
  import request from 'supertest';
  import express from 'express';
  import routes from '../src/routes/attractionsRoutes.js';
  const attractionsService = require('../src/services/attractionsService');
  
  // CORRECT
  const attractionsService = require('../src/services/attractionsService');
  const { calculateDistanceKm } = require('../../common-utils/src/geoUtils');
  ```

- **Missing Dependency**: `common-utils` was not installed as a dependency

#### Solutions Applied:
1. Fixed the typo: `calculateDistancekm` → `calculateDistanceKm`
2. Changed import paths from relative to module reference
3. Removed ES6 import statements and standardized to CommonJS
4. Installed `common-utils` as a local dependency: `npm install ../common-utils`

#### Test Results:
✅ **PASS** - 3 tests passing
- GET /nearby-attractions returns JSON with nodes and edges
- GET /nearby-attractions returns error if parameters are missing
- attractionsService.findNearbyAttractions returns nodes and distances from given coordinates

---

### 2. **Restaurants Service**
#### Issues:
- **Missing Dependency**: `common-utils` module not installed
  ```
  Cannot find module '../../common-utils/src/geoUtils' from 'src/services/restaurantsService.js'
  ```

- **Incorrect Import Path**: In `src/services/restaurantsService.js`:
  ```javascript
  // WRONG
  const { calculateDistanceKm } = require('../../common-utils/src/geoUtils');
  
  // CORRECT
  const { calculateDistanceKm } = require('common-utils/src/geoUtils');
  ```

#### Solutions Applied:
1. Installed `common-utils` as local dependency
2. Updated import path to use module reference instead of relative path
3. Ensured all devDependencies were installed (jest, supertest)

#### Test Results:
✅ **PASS** - 3 tests passing
- GET /nearby-restaurants returns JSON with nodes and edges
- GET /nearby-restaurants returns error if parameters are missing
- restaurantsService.findNearbyRestaurants returns nodes and distances from given coordinates

---

### 3. **Nearby Service**
#### Issues:
- **Missing Test Script**: No `test` script defined in `package.json`:
  ```json
  "scripts": {
    "start": "node src/index.js"
    // Missing: "test": "jest"
  }
  ```

- **Missing DevDependencies**: Jest and Supertest were not installed:
  ```json
  "devDependencies": {
    // Empty - should have jest and supertest
  }
  ```

- **Module Not Found**: Controllers file naming mismatch:
  ```
  Cannot find module '../controllers/nearbyCitiesController' from 'src/routes/nearbyCitiesRoutes.js'
  ```
  - File was named `nearbyCitiesControllers.js` (with 's')
  - Import was looking for `nearbyCitiesController` (without 's')

- **Missing Dependency**: `common-utils` not installed

- **Incorrect Import Path**: In `src/services/nearbyCitiesService.js`:
  ```javascript
  // WRONG
  const { calculateDistanceKm } = require('../../common-utils/src/geoUtils');
  
  // CORRECT
  const { calculateDistanceKm } = require('common-utils/src/geoUtils');
  ```

#### Solutions Applied:
1. Added test script to `package.json`:
   ```json
   "scripts": {
     "start": "node src/index.js",
     "test": "jest"
   }
   ```

2. Added devDependencies to `package.json`:
   ```json
   "devDependencies": {
     "jest": "^29.7.0",
     "supertest": "^6.3.4"
   }
   ```

3. Fixed the import path in `src/routes/nearbyCitiesRoutes.js`:
   ```javascript
   const controller = require('../controllers/nearbyCitiesControllers');
   ```

4. Updated import path in `src/services/nearbyCitiesService.js` to use module reference

5. Installed all dependencies: `npm install` and `npm install ../common-utils`

#### Test Results:
✅ **PASS** - 3 tests passing
- GET /nearby-cities returns JSON with nodes and edges
- GET /nearby-cities returns error if parameters are missing
- nearbyCitiesService.findNearbyCities returns nodes and distances from given coordinates

---

### 4. **Common Utils**
#### Status:
✅ **PASS** - 1 test passing
- Calculates distance between two points (Haversine formula)

No issues found in this module.

---

## Root Causes Summary

| Issue | Cause | Impact |
|-------|-------|--------|
| Typo in function name | Case sensitivity (`km` vs `Km`) | Function not found at runtime |
| Relative path imports | Module resolution conflict with Jest | Cannot find module error |
| Mixed import syntax | Inconsistent module system usage | Parse/require errors |
| Missing dependencies | Not installed locally | Module resolution failures |
| Missing test scripts | Not configured in package.json | Test command not available |
| File naming mismatch | Controller filename didn't match import | Module not found error |
| Missing devDependencies | Not declared or installed | Jest/Supertest not available |

---

## Files Modified

### Attractions Service
- ✏️ `src/controllers/attractionsController.js` - Fixed import typo and path
- ✏️ `src/services/attractionsService.js` - Fixed import path
- ✏️ `test/attractionsService.test.js` - Removed ES6 imports, standardized to CommonJS

### Restaurants Service
- ✏️ `src/services/restaurantsService.js` - Fixed import path

### Nearby Service
- ✏️ `package.json` - Added test script and devDependencies
- ✏️ `src/routes/nearbyCitiesRoutes.js` - Fixed controller import name
- ✏️ `src/services/nearbyCitiesService.js` - Fixed import path

### Common Utils
- ✅ No modifications needed

---

## Final Test Results

```
PASS  test/attractionsService.test.js     ✓ 1 passed
PASS  test/attractionsController.test.js  ✓ 2 passed
PASS  test/restaurantService.test.js      ✓ 1 passed
PASS  test/restaurantController.test.js   ✓ 2 passed
PASS  test/nearbyCitiesService.test.js    ✓ 1 passed
PASS  test/nearbyCitiesController.test.js ✓ 2 passed
PASS  test/geoUtils.test.js               ✓ 1 passed

Test Suites: 7 passed, 7 total
Tests:       10 passed, 10 total
```

---

## Recommendations

1. **Enforce Naming Conventions**: Use consistent file naming patterns (singular vs plural)
2. **Use Module Paths**: Always use installed module paths instead of relative paths for better maintainability
3. **Standardize Module System**: Use CommonJS throughout (or ES6 with proper configuration)
4. **Documentation**: Keep package.json scripts up to date with all required commands
5. **Linting**: Implement ESLint to catch these issues automatically during development
6. **CI/CD**: Add Jest tests to your continuous integration pipeline to catch failures early

---

## How to Run Tests

Run all tests:
```bash
npm test
```

Run tests with verbose output:
```bash
npm test -- --verbose
```

Run tests for a specific file:
```bash
npm test -- attractionsService.test.js
```

Run tests with coverage report:
```bash
npm test -- --coverage
```

---

**Document Generated**: November 12, 2025  
**Status**: ✅ All Issues Resolved  
**Total Tests Passing**: 10/10
