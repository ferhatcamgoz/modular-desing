# modular-desing
This repository contains an example of how a software project can be written in a more modular way. 
   While developing the project, I used the modular structure that comes with Java 9 and Spring Boot 3 (actually not necessary), and H2DB dependencies for database operations. I designed the project package structure in accordance with the Package by Feature philosophy. My motivation for organising the package structure according to feature is to increase the readability of the project, to manage the dependencies more easily and precisely (I point out the dependencies between features or modules, not those defined in pom.xml) and to easily convert the project into microservices when the scale of the project exceeds the monolith structure in the future. 

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Before running the application, we must install the 3rd party libraries (spring, h2db etc.) that the application uses. For this, we must run the mvn clean install command in our main module.

```bash
mvn clean install
```

```bash 
cd application
```
Then I go into the application module where the main method of the application is located and run the command 

 ```bash 
 mvn spring-boot:run
```
