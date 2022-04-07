
# 1. Download Repository

- Go to url: `https://github.com/BillyBolton/DCMS`
- Clone repository to local computer.
  - With https: `https://github.com/BillyBolton/DCMS.git`
  - With SSH: `git@github.com:BillyBolton/DCMS.git`
- Navigate to the cloned repository on your computer: `cd DCMS`

# 2. Explore Code Base

- Postgres SQL schema: `api/src/main/resources/schema-postgres.sql`
- Postgres SQL data: `api/src/main/resources/data.sql`
- CRUD SQL scripts: `api/src/main/java/ca/me/proj/repository/**`

# 3. Boot the Backend

- Ensure terminal is in the project's root directory.
- From the terminal, run: `clear && ./gradlew api:clean api:build api:bootRun`
- Wait for the app to boot. The percentage on screen should stall at a number greater than `80%`
- Test that the backend has been booted properly by navigating to the url: `http:localhost:8080/api-docs/swagger-ui`
- Optional: Feel free to test any of the endpoints on this page.
- Problem? Please contact: `Billy Bolton - bbolt049@uOttawa.ca` and `Jake Kellett - @uOttawa.ca`

# 4. Boot the Frontend

- Open a separate terminal window.
- Ensure terminal is in the project's root directory.
-
- Problem? Please contact: `Boss Girl - bGirl@uOttawa.ca`

# A. Technology Used

- Design Pattern: `Model-View-Controller`
- Postgres Database hosting: `Heroku`
- Backend RESTful API: `Spring Boot + Spring Data framework`
- Frontend UI: `React + Semantic UI`
