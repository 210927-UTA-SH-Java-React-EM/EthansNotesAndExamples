# SQL Overview

## Database:
A collection of structured data, typically grouped into tables
- Each table has rows and columns
    - The row will hold the information about the particular entry
    - The columns are the attributes of the items in the table

## Primary Key:
Unique identifier for each entry in the table
- Each row will have only one primary key, but a primary can consist of mutliple columns, (composite key)

## DBMS and RDBMS

DBMS: Database Management System
- These are what we use to store and manage data in our database
- The ultimate goal of a data base it to persist data

RDBMS: Relation Database Management System
- This is what we will be using during training
- Relational Databases are used to store information in tables that have relations with one another
- RDBMS's are structured so that it maintains the security, accuracy, integrety and consisistency of data

## SQL: Structured Query Language

Underlying Language used to query relational databases
- Not a programming language
- Has an English like syntax

# Database Vendors

There are many different RDBMS vendors/flavors of SQL:
- Oracle
- PostgreSQL
- MYSQL
- Microsoft SQLServer
- Microsoft Access

# Datatypes

Tables in your databases have attributes that describe the data being stored in the row, these attributes can be of many different datatypes

Common datatypes:

- boolean (bool): evaluates to true or false
- character (char[n]) : a fixed length character string
- character varying (varchar[n]): a varying length string of characters
- date: calendar date
- integer (int): whole number
- numberic/decimal: a decimal number

PostgreSQL documenation on datatypes:

https://www.postgresql.org/docs/9.5/datatype.html

# Schema:
A database schema refers to the formal structure of data defined by a relational database, this includes:
- the various tables in the data and their columns and data types
- the relationships between tables in the database

Schemas enforce contraints when defining tables, so we can visualize them through Entity Relationship Diagrams

## Entity Relationship Diagrams:
Illistrate how different tables in a database relate to one another

They contain three main components:

The entity:
- What the table is representing

Attributes:
- These are the columns of the table

Relationships:
- Theses are the connections between the tables

# SQL Sublanguages

There are 5 sublanguages in SQL

## Data Definition Language (DDL):

- Use to define the database itself
- Deals with creation, alteration, or deletion of tables, schemas, or databases themselves
- Syntax/Keywords for DDL:
    - CREATE: used to create a new table, schema, or database
    - ALTER: used to make changes to a table, schema or database
    - DROP: used to completely remove/delete a table
    - TRUNCATE: used to remove the data from a table, but keep the structure intact

## Data Manipulation Language (DML):

- Used to change data inside of the database
- Often refered to as the CRUD operations (Create, Read, Update, Delete)
    - This is the theoretical construct of what you should be able to do with data in a table
- Syntax/Keywords for DML:
    - INSERT: used to add data into a table
    - SELECT: used to retreive data from a table
    - UPDATE: used to update data in a table
    - DELETE: used to remove data from a table

## Data Query Language (DQL):

- This one is often debated, however it exists in PostgreSQL so we teach it
- The debate itself is whether is should its own sublanguage or a sublanguage of DML
- Syntax/Keywords for DQL:
    - SELECT: used retrieve data from a table
- Typically DQL refers to when we use SELECT with constraints, aka the "WHERE" clause

## Data Control Language (DCL):

- This sublanguage is ued to manage the security and control of our databases
- Syntax/Keywords for DCL:
    - GRANT: grant any permissions to a user
    - REVOKE: remove any permissions to a use

# Constraints

Constraints are restrictions that we can put on the columns of our tables in SQL

Some constraints are:

- Composite keys: a key that uses more than one column
- Not null: the column must have data
- Unique: no two records entered inot this column can be the same
- Primary Key: denotes that this column is a primary key
- Foreign Key: denotes that this columnis pointing to an attribute on another table
- Default: create a default value if one is not given
- Serial: the old way to implement an auto generated primary key
- Indentity: the new way to create a primary key automatically

# Other Notible Keywords:

- WHERE: used to narrow down the query results of your SELECT statement
- ORDER BY: used to sort data returned by the select statement by a specific row
- GROUP BY: used to group rows by a column and perform an aggregate function on them
- HAVING: similar to the WHERE clause, but used in conjunction with an aggregate function

## Transaction Control Language (TCL):

- Used to manage transactions within the database
- A transaction is any change that happens to our table
- Syntax/Keywords for TCL:
    - COMMIT: with will perminently save any DML operations that occured
    - ROLLBACK: with wil completely erase any DML operations that occured between two commits. But keep in mind once you commit you cannot rollback
    - SAVEPOINT: create a spot to rollback to

In SQL every transaction must have a specific four properties, these are know as the ACID properties

## Four Properties of a Transaction:

Atomic: All of nothing, the transaction if fully complete, or it doesn't happen at all

Consistency: The tables shema will remain intact after the transaction

Isolation: Each transaction cannot affect the results of another transaction

Durability: Data will persist through system crashes and other issues

## Read Phenomena

Lost Updates: Transaction1 updates the data, then Transaction2 updates and commits successfully, the update by Transaction1 are lost

Dirty Read: T1 updates the data but hasn't committed, then T2 reads the uncommitted data

Unrepeatable Read: T1 reads the same record twice and the state of the record is different, the records was changed by T2 right before T1 read again

Phantom Read: T1 executes a query on a set of records, T2 inserts a new record into the table that happens to be in that set, then T1 reads more data than expected

# Multiplicity in Databases

Multiplicity is the relationship between entries in different tables, defined by foreign key constraints

## Foreign Keys

- Make relations between tables
- Do not need to be unique, but can be
- Can be made of one or more columns
- A foreign key made of multiple columns is called composite key

## Four Types of Multiplicity

1. One-to-many: one entry in the first table can be mapped to many entries in the second table
    - The foreign key in the first is allowed to map to multiple entries in the second table
2. Many-to-one: this is the opposite of one-to-many
3. Many-to-many: Many entries of the first table can be mapped to many entries in the second table
    - These are implemented with what are called junction tables
4. One-to-one: a single entry in the first table is mapped to a single entry in the second table
    - The foreign key of both tables are unique

## Referntial Integrity

- A foreign key is the reference to the relationship in multiplicity, and the rule ensures that a referenced record always exists
- You are not allowed to delete an entry if an entry of another table depends on it
- You can use cascade delete, which will delete all children and parent entries

# Aggregate and Scalar Functions

## Aggregate functions take multiple rows, and combine the values into a single column

Some popular aggregate functions:
- MAX(Column): returns the max value of that column
- MIN(Column): returns the min value of that column
- AVG(Column): returns the average value of that column
- SUM(Column): returns the sum of the values in that column
- COUNT(Column): return the number of elements in that column

These functions are used in the SELECT clause, and cannot be used with the WHERE clause

If more than one column is being selected in the SELECT column section, a GROUP by is required

You can also use the HAVING clause with an aggregate function instead of WHERE

## Scalar function operates on a single row, these can be used with SELECT and WHERE

Some popular scalar functions:

- LENGTH(string): returns the length of a string in the given row
- UPPER(string): return the string in all upper case
- LOWER(string): returns the string in all lower case
- ABS(num): returns the absolute value of the number
- CEILING(num): returns the number rounded up
- FLOOR(num): returns the number rounded down