# Modular Desing
This repository contains an example of how a software project can be written in a more modular way. 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

![image info](https://miro.medium.com/v2/resize:fit:720/format:webp/1*CAotacFcEKIO7aY97tcb5Q.png) 

## Motivation
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
While developing the project, I used the modular structure that comes with **Java 9** and Spring Boot 3 (actually not necessary), and H2DB dependencies for database operations. I designed the project package structure in accordance with the ***Package by Feature*** philosophy.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
My motivation for organising the package structure according to feature is to increase the readability of the project, to manage the dependencies more easily and precisely (I point out the dependencies between features or modules, not those defined in pom.xml) and to easily convert the project into microservices when the scale of the project exceeds the monolith structure in the future. 

### Readability
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
I respect everyone's opinion on this subject, but when I browse the project packages, it makes my job much easier to get an idea of what the project does. It also saves me the tedious job of looking for code between files because the package itself tells me which code is where.

### Dependencies Within the Project
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
One of the unquestionable top three reasons for our transition to microservices has been the dependencies within the application. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Unfortunately, I believe microservices have further exacerbated this issue. In the past, despite the complexity of dependencies within the application, there was no need to use third-party technologies. However, in microservices, as services are completely isolated from each other, there was a need for a third-party structure (HTTP seems to be the most widely used model). But in this case, there was also a need for request and response models for the data to be transported between services, and to ensure that these models work correctly and error-free in both communicating services, additional packages were used (such as JSON), implying the elimination of transaction management. And, in my opinion, most importantly, the application was built relying on a third-party system. Especially with HTTP, even though it works with 100% accuracy, it means latency for applications running in different regions and servers. Moreover, even though we may not have a clear idea of whether scalability is needed or not :)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Above, I provided a simple example of the communication architecture stemming from the dependency architecture. A mandatory need for a communication technology that will work seamlessly between the two services that will communicate in the communication architecture has arisen. But I am a software engineer. I would prefer to work directly with domain code rather than HTTP (at least I can customize it according to my preferences).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
In this project, dependencies have been managed in the simplest way. ***Encapsulation**** and ***Java 9 Modules***.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Inside each module is a module-info.java file. Thanks to this file, it has been definitively determined which packages within the module will communicate with the outside world and which models it will use. Here, dependency management is done using Spring for Dependency Injection, and it is possible to build an extensible structure using different frameworks.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The key point here is leaving dependency management directly to the developer and, based on future requirements, opening or closing specific parts of the module to the outside. And now, we have solved the communication (dependency) problem.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
![image info](https://miro.medium.com/v2/resize:fit:720/format:webp/1*1Gp2CkZKaj_myY9srSWaiQ.jpeg)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
While writing this code, the goal was to achieve loose coupling and high cohesion, just as depicted in the upper diagram. To learn more about the concepts of Coupling and Cohesion, which are directly related to the structure, you can visit [Coupling ve Cohesion](https://medium.com/clarityhub/low-coupling-high-cohesion-3610e35ac4a6)

### Transformation to Microservices.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The independence provided by the package structure and modularity actually resembles microservices directly and seems like easy versions of them. With potential future developments, our application may acquire many new features, an increased number of developers (especially remote ones :)), and a larger customer base. In such a scenario, it might be necessary to transform some modules into microservices. In such a case, one can almost seamlessly leave the project without the need for any additional development. From then on, it is only left to determine how the module will communicate with the other modules it depends on.

Notice that 2/3 of the reasons I listed above for transitioning to microservices are social, and 1/3 is technical. In my opinion, the most crucial decision to make in transitioning to microservices is to assess how ready the social environment of the project is for this transformation.


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
