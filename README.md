# modular-desing
This repository contains an example of how a software project can be written in a more modular way. 

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
