# Wrapping Up Spring Boot Content

# Lombok

Is a Java library that automatically plugs into your editor and build tools, spicing up your java. You will never have to write another getter, or equals method again, with one annotation you class has a fully featured builder, automate your logging variables and much more.

Lomboks goals are to reduce boiler plate code by generating it at runtime, this includes:
- Getters and Setters
- No Arg Constructors
- toString Methods
- equals
- hashcode
- logging variables

Instructions to install lombok

https://projectlombok.org/download

Download and run the jar

Include lombon in your project dependencies

# Spring Boot Actuator

Is a spring library that exposes tools for monitoring and gathering metrics about a running application

You can utilize Actuators predefined endpoints to view different information about your application

-   /health : shows the application health
-   /beans : shows a list of available beans in the BeanFactory
-   /env : return the current application properties
-   /info : return general data can be customized
-   /logfile : return the content of the logfile
-   /loggers : show and or modify logger configurations
-   /mapping : show all @RequestMappings
-   /metrics : show metric information about the application
-   /shutdown : shutdown the application

In the application.properties you can turn on or off specific endpoints

# Spring Boot DevTools

Implements two useful features:
- Cache disabling: cache is helpful in production, but can hinder development workflow, devtools automatically disables
- Automatic restarts: anytime you want to make a change to your application, the development server will restart for you

# Spring Environments / Profiles

Allows us to map beans to different profiles, allowing us to have different versions of our beans
- different database connections for different environments

This allows for best practices of separating your working environments, from development, testing, and production

To map a bean to a specific profile/environment, simply annotate the bean class with `@Profile("environmentName")`

To set the active profile simply set it in the application.properties with `spring.properties.active-'environment` value

You can also set dependencies for Spring based on the environment in the application.properties:

```
# properties for all profiles
---
spring:
  profiles:
    - dev
  # properties for dev environment
---
spring:
  profiles:
    - prod
  # properties for prod environment
```

# Validation

Spring validator interface is used to validate objects. The interface works by using Spring Framework Error objects, so that while validating, validators can report these validation failures to the Errors object

Spring Errors Interface stores and exposes information about data-binding and validation errors for objects

Spring Errors also can output messages by using MessageSource

# Overview of Webservices

A webservice is a software that allows machines to exchange and make use of information over a network

These services must comply to a set of standards, and be exposed via a consumable API

Two types of webservices:
- REST
- SOAP

Advantages of Web Services:
- We can use the web as a transactional tool, rather than simply to display data
- Expose functionality of a business service both within and outside of your application, making your functinality reusable by others
- Captialize on existing standards, create standardization
- Hardware and OS independent
- Loose coupling of programs

# Rest Concepts

Rest Stands for Representational State Transfer

Is an architectural style that outline communication between client and a server

The outline is a set of guides for developing a webserver

To RESTFul the webservice in question must follow these 6 constraints:

1. Uniform interface: the service must adhere to a commonly decided API standard:
    - Identification of resources: URL
    - Manipulation of resources through representations: a request yields the start of a resource
    - Self descriptive
    - Hypermedia as the engine of application state
2. Client-Server: separation of concerns
3. Stateless: the server should no retain any information about the clients session
4. Cacheable: Responses should be explicitly labeled as cacheable or not
5. Layered System: the system should be separated into layers such that components only interact with components that are part of the same layer
6. Code on Demand: an optional constraint that allows executable code or scripts to be sent with responses


Resources in REST is any information that can be named

We typically represent these resources with some standard such as XML or JSON

To identify resources with a RESTful service we use URL's  (Unified Resource Locatator), this is called the recource identifier

RESTful services should have uniform resource identifiers, so here are some rules you can follow to conform to this:

- use nouns to name resources
- begin your uri with the plural collection of a particular resource
- use path parameters to identify single resource in a specific/record
- capitalize on path structure to represent hierarchy
- identify store of resources that are managed by the client (sub-collections)
- use query parameters to filter resources of a particular type
- be consistant across the board

