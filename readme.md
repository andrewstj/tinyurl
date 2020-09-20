See requirements [here](requirements.md)

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

## Approach
The approach I used was:
- Utilize Spring Boot to be able to quickly bootstrap a Java application
- Use H2 in memory database to get a quick Relational DB as persistent store
- Use JPA / Hibernate so when switching to production database we don't have to switch code
- For the [URLEncoder](src/main/java/com/tjandrews/tinyurl/business/UrlEncoder.java), allow for encoding / decoding Integer ID <-> String URL Path

The main code prinicples followed here are:
- Layered architecture (gui, presentation, business, infrastructure)
- Separation of Concerns (Helped by layered architecture)
- Single Responsibilty (Don't have functions or classes doing more than they should)
- Dependency Inversion (Injecting implementation at runtime helps testability)

### Caveats
- The URL it redirects to is currently hardcoded to path `/r/{encodedPath}` (r is short for redirect), because using base path would then override ability to have other endpoints, such as `POST /urlMapping`
  - A fix to that would be to have a different URL for creating and for redirecting 
- Used Integer instead of Long for the ID as it can hold up to ~2.15 billion urls, if we need more:
  - We could create more tables that each belong to a base path (`/a/`, `/b/`, etc)
  - We could utilize a compound key on the table where it's the Id and the base path (`a1`, `b1`, etc)
  - We could use a Long, but this will result in longer encoded path that maps to such a large number, as well as a longer lookup time in the single table for that many URLs and we still need to index

# Run
Pre-req: Must have Java 8 installed and JAVA_HOME set

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

# Test

`./gradlew test`
or
`./gradlew.bat test`