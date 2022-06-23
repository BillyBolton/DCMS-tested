# DCMS

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=BillyBolton_DCMS-tested&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=BillyBolton_DCMS-tested)

## Video Walk-Through

- [Click here](https://youtu.be/d8amBgz9ddc)

## Prerequisites

- [Downloading and installing Node.js and npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)

## 1. Download Repository

- Go to url: `https://github.com/BillyBolton/DCMS`
- Clone repository to local computer.
  - With https: `https://github.com/BillyBolton/DCMS.git`
  - With SSH: `git@github.com:BillyBolton/DCMS.git`
- Navigate to the cloned repository on your computer: `cd DCMS`

## 2. Explore Code Base

- Postgres SQL schema: `api/src/main/resources/schema-postgres.sql`
- Postgres SQL data: `api/src/main/resources/data.sql`
- CRUD SQL scripts: `api/src/main/java/ca/me/proj/repository/**`

## 3. Boot the Backend

- Ensure terminal is in the project's root directory.
- From the terminal, run: `clear && ./gradlew api:clean api:build api:bootRun`
  - If the above command does not work, try running the following command instead: `clear && gradlew api:clean api:build api:bootRun`
- Wait for the app to boot. The percentage on screen should stall at a number greater than `80%`
- Test that the backend has been booted properly by navigating to the url: `http://localhost:8080/api-docs/swagger-ui`
- Optional: Feel free to test any of the endpoints on this page.

- Problem? Please contact: `Billy Bolton - bbolt049@uOttawa.ca` and `Jake Kellett - jkell114@uOttawa.ca`

## 4. Boot the Frontend

- Open a separate terminal window.
- Ensure terminal is in the front-end project directory: `cd ./DentistOffice/react-login`
- From the terminal, run: `npm install && npm start`

- Problem? Please contact: `Rachel Jamer - rjame070@uOttawa.ca`

## A. Technology Used

- Design Pattern: `Model-View-Controller`
- Postgres Database hosting: `Heroku`
- Backend RESTful API: `Spring Boot + Spring Data framework`
- Frontend UI: `React + Semantic UI`
