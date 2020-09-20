For requirements see [requirements](requirements.md)

# Overview
This application exposes RESTful API's to create a TinyURL. 

## Technologies Used
- Java 8
- Spring Boot
- H2
- Hibernate
- JPA
- Lombok (trim down boilerplate Java code)
- Swagger

# Running
Pre-req: Must have Java 8 installed and JAVA_HOME set

At the top level directory

`./gradlew bootRun`
or
`./gradlew.bat bootRun`

After starting the application, you can see the swagger API's at:

http://localhost:8080/swagger-ui.html#/

![Swagger](screenshots/swagger.png)

To view the database go here:
http://localhost:8080/console

And put in parameters like this (password is sa):
![Database](screenshots/dbConsole.png)