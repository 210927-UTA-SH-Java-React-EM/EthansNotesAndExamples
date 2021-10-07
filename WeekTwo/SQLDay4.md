# Sub-queries:
A query inside of a query, you can replace any DML statement with a SELECT statement
- use the results from the inner query in the outer query

# Joins:
a way to combine two tables on specified columns/denormalize tables
- Normally comparing primary and foreign keys
- They can be done on any column as long as the types match

# Types of Joins:

## Inner
Is the most common, it returns rows that match the specified join clause

## Outer
The Outer keyword can be used with LEFT RIGHT and FULL to specify what kind of outer join you like to do

## Left
Returns the matching rows and the ones that are null on the first table

## Right
Returns the matching rows and the ones that are null on the second table

## Full
Returns all rows from both tables, including the ones that are null from both tables

## Self
This performs an inner join between two columns inside the same table, representing a hierarchy

## Cross
Returns the cartesian product or two or more tables

## Natural

Will join tables based off of matching column names

![joins](https://www.postgresqltutorial.com/wp-content/uploads/2018/12/PostgreSQL-Joins.png)

# Set Operators:
Similar to joins, however instead of joining tables, they combine rows of returns sets from queries

Some important Set Operators are:

## Union: returns everything between the two sets without duplicates
Union All will return duplicates

## Intersect: returns the records the queries have in common

## Minus: Removes any row from the first set, that is also present in the second set, and returns the result

## Except: Does the opposite of minus

# Indexes

Indexes are used to speed up the look up of rows in a database
- cerated on individual table columns which you expect to be looked up often
- primary keys are automatically given indexes

When an index is created on a database column, a separate data structure is created in the database, typically some sort of balanced tree, which stores references to the actual records in the table

Speeds up retrieval time, but loses effiency inserting new data

Only create an index when you anticipate heavy searching of a particular column

## Types

There are many types of indexes, however they are split up into two categories: clustered and non-clustered

Clustered Indexes: alter the order in which the records are physically stored on the disk. Only one of these can be created per table

Non-clustered Indexes: specify a logical ordering of rows, but do not alter the physical ordering in the table. There may be more than one per table

A list of index types includes:
- Bitmap
- Dense
- Sparse
- Reverse
- Primary
- Secondary