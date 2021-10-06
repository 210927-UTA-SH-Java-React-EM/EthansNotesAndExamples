# Normalization

Normalization refers to reducing redundancy of data and improving data intregrity and consistency

We focus on the first three forms:

## First Normal Form

- Must have a primary key
- No duplicants
- Atomic Columns (break the columns up as small as you can)

## Second Normal Form

- Must be first normal form
- All attributes must depend on the primary key, (no partial dependencies)

## Third Normal Form

- Must be second normal form
- There are no transitive dependencies (data should only relate to the primary key nothing else)

### They key (1NF), the whole key (2NF), and nothing but the key (3NF), so help me Codd

# JDBC

Java Database Connectivity, allows us to write java code to interact with relational databases

# Interfaces of JDBC

There are several classes and interfaces commonly used with JDBC, which can be found in the java.sql, and javax.sql packages:

- `DriverManager` class - to make a connection with a database driver
- `DataSource` interface - for retrieving connections, an alternative to `DriverManager`
- `Connection` interface - represents a physical connection with a database
- `SQLException` class - a gernal exception throw when something foes wrong when accessing the database
- `Statement` interface - used for executing static SQL statemtents
- `PreparedStatement` interface - represents a pre-compiled SQL statement
- `CallableStatement` interface - used to execute a stored procedure
- `ResultSet` interface - represents data returned from the database

# Setting up the Database Driver and a connection

To establish a connection to the database, we will need what is known as a driver
- These are database engine specific
- You can get these through Maven Dependencies in your pom.xml

```xml
<!-- https://mvnrepository.com/artifact/postgresql/postgresql -->
<dependency>
	<groupId>postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>9.1-901.jdbc4</version>
</dependency>
```

# Connection Interface

To create a connection you use the DiverManager.getConnection() method, with these parameters
- URL to database (jdbcL:postgresql://hostname:post/databasename)
- username
- password

# Design Pattern: Data Access Object (DAO):

This is a design pattern we will be following to separate our business logic from our database access
- You will create an interface with method stubs of your database calls
- Implement that interface with concrete DAO classes

This pattern results in reusable code, and cleaner project structure

# PL/SQL (Procedural Language SQL):
allows us to create functions and other reusable bits of sql
- It is closer to a programming language

## Sequence:
An object that holds a number that starts a certain point, and increments util it potentially reaches a max value
- You increment with NEXTVAL

## Trigger:
A block of code that executes when an event happens

## Cursor:
A pointer to a result set, you can use these to loop programatically through the output of a select statement

## Views:
Virtual table in SQL, they are created using DQL statements

Advantages of Views"
- Gives access to some but not all of the data in a table
- Hide complexity of a database from users
- Allow users to query normalized tables easily
- Changes to the underlying table(s) are automatically reflected in views

## Stored Procedures:
Reusable code in PL/SQL that has these properties
- Don't return anything
- May or may not contain IN and OUT parameters
- They allow any DML statment within
- Can call other stored procedures
- Cannot use them in DML statements

## Functions:
Reusable code in PL/SQL that returns a value and has these properties:
- Allow cursors
- Should be a single value
- They may or may not contain IN parameters
- Only Select statements are allowed
- Can call other functions
- Can be used in any DML statement
- You have to use a DML statement use them