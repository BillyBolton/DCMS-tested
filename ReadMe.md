## Running multi-module projects from command line
Individual
`./gradlew api:bootRun`

Parallel
`./gradlew bootRun --parallel`


## Running with Eclipse and Spring Boot extension
`Right-click project -> Run As -> Run Configurations -> type the desired profiles in the Profile field`

## Explore H2 Database
- Navigate to: `http://localhost:9080/h2-console` when running the local (default) profile.