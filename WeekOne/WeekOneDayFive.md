# Introduction to Maven

Maven is a dependency manager and build automation tool for Java programs

Maven project configurations and dependencies are handled in the Project Object Model, or the pom

## Project Coordinates:
how Maven identifies projects, these are defined in the pom.xml and include:
- group-id: for example com.example
- artifact-id: for example myproject
- version: for example 0.0.1-SNAPSHOT
- These uniquely indentify a specific version of a project

## Project Object Model (pom.xml)
- Contains information about the project used to build the project, including dependencies and plugins
- Some important tags in the pom:
    - <project> - this is the root tag of the file
    - <modelVersion> - defining which version of the page object model to be used
    - <name> - name of the project
    - <properties> - project specific properties
    - <dependencies> - this where you put your Java dependencies you want to you. Each one needs a <dependency> which has:
        - <groupId>
        - <artifactId>
        - <version>
    - <plugins> - third party plugins that work with Maven

# Maven Repositories

When Maven builds a project, it must search for any dependencies declared in the pom.xml

These dependencies are stored both locally and in a central repository

- Locally Maven store these dependencies in at $HOME/.m2/repository by default
- The central repository with is accessible at https://mvnrepository.com

If Maven cannot find a dependency locally, it will go to the central repo and download it

# Maven Lifecycle

When Maven builds a project, it takes all the source code, and dependencies and compiles and bundles it into an artifact, this can be a .war, .jar, or .ear,
- You can either run this directly, or deploay it onto a web containers

There three built in life cycles for Maven
- Default which handles project deployment
- Clean which handles project cleaning
- Site handles the creation of out project sites documentation

When Maven builds your project, it goes through several steps called phases. The default Maven build lifecycle foes through the following steps:

1. Validate => project is correct and all neccessary information is available
2. Compile => compiles the project source code
3. Test => test all compiled code
4. Package => packages all compiled code into WAR/JAR file
5. Integration => performs all integration tests
6. Verify => runs checks on the results of the integration tests
7. Install => install War/Jar to local repository
8. Deploy => copies the final Jar/War to the remote repository

# Overview of Logging

Logging records events that occur during the execution of your program

- They allow for developers to access information about application for which they do not have direct access
- Without logs developers would have no idea what went wrong when the application crashes

We will being using Log4j for logging
- Log4j is a reliable, fast, and flexible logging framework for Java supported by apache
- It is commonly used to record application events, log granular debugging information, and write exception events to files

Log4J allows us to use various logging levels, and configurable thresholds that determine which messages will be recorded in the application log file

Log4j Logging Levels:
1. ALL => all levels
2. DEBUG => designated for fine graned informational events that are most useful to debug an application
3. INFO => informational messages that highlight the progress of the application at the coarse grained level
4. WARN => designates pottentially harmful situations
5. ERROR => designates error events that might still allow the application to continue running
6. FATAL => severe error events that presumably lead the application to crash
7. OFF => highest possible level, intended to turn off logging