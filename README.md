# Mediscreen Patient
## Technical:

1. Framework: Spring Boot v2.6.3
2. Project Maven
3. Java 11
4. Spring Data JPA
5. MySQL Driver
6. Spring Web
7. Lombok
8. JaCoCo
9. SureFire
10. Validation
11. Swagger

## Setup MySQL for local testing
1. Change the "DataSource Configuration" in file src/main/resources/application.properties.
2. Run the scripts in src/main/resources/MySQLDataTest :
3. 1-trigger_words.sql : create the database "mediscreen_patient", the table trigger_words" and populate it.
4. 2-patients.sql : create the table "patient" and populate it with data from sprint 1.

## Use
1. The service address is http://localhost:8081.
2. The Swagger documentation for the API is available at the adress http://localhost:8081/swagger-ui.html.

## Docker service
1. After importing all services (patient, history, assessment and Web UI).
2. On local, create a folder for the MongoDB database.
3. In the docker-compose.yml file for the "mediscreenmongodb" service (line 74), replace the string "D:/DataBases/MediscreenMongoDB/data" with the new folder.
4. On local, create a folder for the MySQL database.
5. In the docker-compose.yml file for the "mediscreenmysql" service (line 87) replace the string "D:/DataBases/MediscreenMySQL" with the new folder.
6. Run the command "docker-compose up --build" from the folder of this project.
7. The Web UI address is http://localhost:8083.
