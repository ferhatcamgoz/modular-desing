
# Modular Desing
This repository contains an example of how a software project can be written in a more modular way. 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

![image info](https://lh3.googleusercontent.com/fife/AGXqzDkdyLFE0s4hFhWnVoiFW0ih5N22Ohp4DCgCgl9n3wHIXAgc8dBNX5X51vcNqegJahtw4-MXlUGdfg-_HH_o315tGcQAUrKv-jNwz7gJD86brz9s9HElBEKQ-SHLI-qrRBgqmrYjaCRBcdXqN9RkERtUnCOxy8AXojghJZfEfGcwWx1svttSW7-Q7agu7p7B8VXoGG1SkbaVeVwhsWiW9mlSzTaALYNmcBwTeao_yIU6FCyz2wN8Hc1YXEsjy5rvC76JVJ95WNOmRQbEm_5tfVlYg1W29FV-wdX5JGCcHG6diOHzlIBuDzabgnfoDTHV4QBLuSMe6ieI8IU-liEAuMcLAEe0F79x_Ryu3UbQHshUuK-AFm7HsvV8-8qhU5OUQxbw6qGlG3_TdcX-ZF7_CWJCTKq9tUn7Tpw-64lnerAa1BBZtYUnoiBVrf9xfpZm72yA3NG1XArF_psoor2RDJ5KM0_bgW3l-ajebK2XJlktrHWOQ3Hc06YwAha0PPIerd_Gym5hOqGZEQEnqZurd5jir6DVZjyrpD_RXrtPSwW5qHKOFQt2q5DEGtCNV5Ba1yufpMRlMbcK77KkkDgZoQzM6IoJ0H-G9BcNGmE8AdsYSk7n_B3auXRkXeTdVpbNRNG9vtv3T9R8cEtxNQzXabfXdpSS_Xk3C9MgiGi7g9YnIOpRnBokgBi4YwEdg_9xguvVznW8yNtmiSQ48mBoCYDVxRcMmDmofIkApMpui3DPoYi-793uNzVe9rSZE0jNpDdspRshtjmQ7EYlQ8psg5pahmxz8x-5eyB9dCcA-Rsmfm051f4oF_Hyh04018VGv-hVAsGCPzo22uMwEfEHnR9kO8gowAqNU-nzCQydVT0PCa6PRXJJ147yCFZGDe1jmyAhfl_L25Jflsh3KqVgBg8hTRKTWXDGPpsVGNMgLqNiu2VUffTV_pYMe2usGtTZ8Zr8SSPPbvYwM7E57MzGZB0diKLEIN_98KSBzl3TmG6BDHRpja6ctpJFVCFT6AP7kK1rjw7OCH-IXfrShfvfjgRqdkJeb3q6DKw70HTV5q12-oujby_tzHcJiFC6-FICbRbuqOeRdcUnUgA6irkp4kZUNFjBU_oCe--l8oEC_T5d7Dem6ULPzLJXOHLul5ZfRgJeX_ByBuWd_WzxZ0nSrWnjFOIxUalFK2CQZFdNrim9Jstlt8Kpw0kNtiujk59rlIfujljFuJOc9FUDCSd4EMwvonwfeHJ_oUIhc97ZmL7dbieqZv50C6DubpJTHJBEVcZ_pxNZbr9VOSP1nKiBhfg9eYCxwULwYyi1c9jb08BpF6n75pUF_DreUQdoDeBNbbfVr_qsjfdabpp7x3bezGLQeM8B9I5H4TnyaS3f7sahQ6MtHFYaAV8pj_Q-N7La0ixDXVJGn7YxNITGVvkAopSih6ySfGqy1FluVQe2L3Hcm2XaKTCy-cYnEGeiqGyAIHs4TXbfKNu9mP_D5SLvIqoXh75-VIeeAsrbab46IrHx_Y9F4eY4JnGCbu0=w1106-h968)) 

## Table of Contents
* [Motivation](#Motivation)
* [Requirements](#Requirements)
* [Technologies Used](#Technologies-Used)
* [Running the application locally](#Running-the-application-locally)
* [License](#License)

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

### Technologies Used

You can use any programming language for implementing Modular Desing. Here is the list of technologies we used for the demo application;

* Spring Boot 3
* Java 17
* Maven 3.9.5
* Mono Repo
* H2DB

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


### License

Distributed under the MIT License. See [LICENSE](LICENSE.txt) for more information.
