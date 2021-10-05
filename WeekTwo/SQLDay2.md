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