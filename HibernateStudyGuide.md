# Hibernate

## Should be in notes, or quick research

1.  What is Hibernate? What is JPA?
- Hibernate is an ORM tool for Java built on top of JPA that provides an interface for any database.
- JPA (Java Persistence API) is the standard Java API that adds an object-oriented layer on top of database operations. The user accesses the database through JPQL and entity classes are updated in the database through the EntityManager.
    
2.  What is the benefit of using Hibernate over JDBC?
- Hibernate is DBMS-independent and allows users to directly map objects to database tables without having to write complicated queries. Hibernate also scales better than JDBC to larger applications or programs and adds caching.
    
3.  Tell me about some of the JPA annotations you have worked with? What do they do? How do you specify multiplicity relationships with JPA annotations?
- `@Entity` marks a class to be persisted in the database, `@Table` provides details about that class, `@Column` marks a field in the database and has the attributes `name`, `length`, `nullable`, and `unique`; `@Id`  marks the ID field for the table, `@GeneratedValue` determines how the ID value is generated
- Multiplicity is specified by the annotations `@OneToMany`, `@ManyToOne`, and `@ManyToMany`. Bidirectional relations use `@JoinTable` for creating junction tables for many-to-many relations, the `mappedBy` attribute for one-to-many relations, and `@JoinColumn` for many-to-one relations.
    
4.  What are the interfaces of Hibernate?
- `Configuration` (class) represents the configuration file for the DB connection and is used to create the SessionFactory,
- `SessionFactory` is a singleton class used to create the session and holds L2 cache,
- `Session` wraps the JDBC connections, is what performs the DB operations, holds the mandatory L1 cache, and serves as a factory for `Transaction`, `Query`, and `Criteria`,
- `Transaction` represents database transactions and is used whenever an operation changes the state of the DB (instantiated by `Session.beginTransaction()`), can represent multiple operations and be committed or rolled back if uncommitted,
- `Query` is obtained by `Session.createQuery()` and is used to create queries written in Native SQL or HQL that are more complicated than what Session can provide, and
- `Criteria` is a simplified API that uses Criterion objects to query the database and is instantantiated by `Session.createCriteria()` ***
    
5.  Tell me how you set up hibernate? What files are you editing, what goes in them, etc.
- Add the hibernate library to a Maven `pom.xml` file unless you are using a Spring Boot project which includes it automatically.
- The `hibernate.cfg.xml` file contains settings for the hibernate SessionFactory configuration, such as the username, password, and URL for the database, the database driver and dialect (e.g. `postgreSQLDriver/Dialect`), `hbm2ddl` which changes how the database is updated when the project runs, and is where entity classes are mapped with the `<mapping>` tag.
    
6.  What ways are available to you to map an object to database entities in Hibernate?
- Using Java annotations or mapping in the XML file
    
7.  In the session interface, what is the difference between save and persist methods? get and load methods? Update vs merge methods?
- `get` returns null for a non-existent object and uses earger loading; `load` throws an ObjectNotFound error for a non-existent object and uses lazy loading.
- `save` returns a Serializable and saves DB changes outside of a transaction; `persist` is void and does not save any changes outside of the transaction.
- `update` throws an error if a detached object already exists in the session; `merge` will update that persistent object with the detached object's values.
    
8.  What are the different session methods?
- The create methods are `save`, `saveOrUpdate`, and `persist`; the read methods are `get` and `load`; the update methods are `update` and `merge`; and the delete method is `delete`.
    
9.  What is the difference between Eager and Lazy fetching and how to setup either?
- Eager loading returns a fully initialized object whereas lazy loading returns a proxy object or reference that is not automatically instantiated
    
11.  What are the 4 ways to make a query using Hibernate?
- HQL, Native SQL, Criteria API, and Named Queries
    
12.  What is HQL? What makes it different from SQL?
- HQL (Hibernate Query Language) is an object-oriented query language that is used to query persistent objects rather than data from a table. It is automatically translated to the dialect given in the XML config file.
    
14.  What is caching? What is the difference between L1 and L2 cache?
- Chaching is saving the results from a query in memory so subsequent identical queries can be loaded more efficiently.
- L1 cache is automatically created by hibernate and is associated with a Session object; L2 is the second level of cache accessed by a Session, is associated with the SessionFactory, and can be accessed by any Session, but it must be implemented through a third party.
    
15.  How do you enable second level caching?
- You must add the following tags to the XML config file:
  - `<property name="cache.use_second_level_cache">true</property>`
  - `<property name="hibernate.cache.region.factory_class">pathforcacheclass</property>`
- You must also annotate the entity class to be chached with the `@Cache` annotation and provide the cache concurrency strategy:
  - READ_ONLY (data is only used as a reference, never changed),
  - NONSTRICT_READ_WRITE (no consistency guarantee, use for classes that are rarely changed),
  - READ_WRITE (data is read and updated),
  - TRANSACTIONAL (full transaction is cached)
    
16. Tell me about NamedQueries.
- Named Queries are SQL/HQL expressions with predefined query strings defined either in the mapping file or the entity class. In the entity class, you use one of the following annotations:
  - `@NamedQueries` for multiple HQL expressions
  - `@NamedQuery` for one HQL expression
    - Has 2 attributes: `name` to specify the name of the query and `query` to specify the actual query
  - `@NamedNativeQueries` for multiple native SQL expressions
  - `@NamedNativeQuery` for one native SQL expression
    
17.  Can you write native SQL with Hibernate? Is this a good idea?
- Yes, by using `Session.createNativeQuery()`, but it is not recommended because it tightly couples the program to the DB.
    
18.  What are the configuration options for Hibernate?

- How to specify the SQL dialect?
  - `<property name="hibernate.connection.dialect">org.hibernate.dialect.{dialect}</property>`

- What data must be specified for the SessionFactory?
  - `org.hibernate.connection.url` (database URL), `.username` (DB user username), `.password` (DB user password), `.driver_class` (used to load/register the JDBC driver class); entity class mappings
    
- What is hbm2ddl?
  - Used to create, update, or validate the database schema DDL (data definition language) when the SessionFactory is instantiated. Can be 
    - `create` (drops table if it exists and creates a new one), 
    - `update` (updates existing tables to match the class mappings), 
    - `validate` (makes sure the mappings match the tables), and 
    - `create-drop` (same as create but drops all tables when the SessionFactory is closed)
    
19.  How would you configure Hibernate to print to the console all SQL statements run?
- Use `<property name="org.hibernate.show_sql">true</property>`
    
20.  What are the different object states in Hibernate? What methods move objects to different states?
- *Transient*: Object is not connected to the database. Can become persistent if one of the `.save()`, `.merge()`, or `.saveOrUpdate()` methods is used on it.
- *Persistent*: Object is a representation of a row that is currently connected to a Session. Can be detached with `.close()` or `.evict()` methods.
- *Detached*: Object is a row that is not being managed by any Session. Changes made will not be reflected in the database. Can be reattached with `.update()` or `.merge()` methods.

## Extra Research Required

10.  Under what circumstances would your program throw a LazyInitializationException?
- When an attempt is made to initialize a lazily fetched object that does not have an active associated Session.

13.  What is the Criteria API? Can you perform all DDL and DML commands with it? How do Restrictions and Projections work within this API?
- A programmatic and typesafe way to access a relational database
- All DDL and DML commands can be invoked with it
- The *Restriction* of a criterion is its `where` clause and is specified via its `.where()` method which takes either an Expression or a Predicate object. *Projections* are the columns that are selected for return and are specified by either the `.select()` method for single column queries or the `.multiselect()` method for queries that return multiple columns.

21.  What is a proxy? When does the proxy resolve to the real object?
- A proxy is a placeholder object that references a row in a database that does not hold any data until that data is requested or the object is manually unproxied.

22.  What is the difference between Dynamic Insert and Dynamic Update?
- Hibernate will insert default values for fields that are not specified in insert/update rows, e.g. a null value for a field in an insert statement. The `@DynamicInsert` and `@DynamicUpdate` annotations will alter the created operation so that only fields with defined values will be specified in the statement.

23.  What is automatic dirty checking?
- Changes made to a persistent object are automatically saved in the database when the Session is flushed.
    
24.  What is Transactional Write Behind?
- Hibernate only updates the state of a database when a transaction is committed. All of the operations performed on the database are stored until `transaction.commit()` is called.
    
25.  Explain how transaction propagation works
- Propagation determines how an operation is added to a transaction
  - `REQUIRED` (default) adds the operation to a newly created transaction if one doesn't already exist, otherwise it is appended to the current transaction
  - `SUPPORTS` The operation will be appended to the current transaction if one exists, otherwise it is run as non-transactional
  - `MANDATORY` The operation is appended to the current transaction if one exists, or an error is thrown
  - `NEVER` If there is an active transaction, Spring throws an error
  - `NOT_SUPPORTED` If there is an active transaction, it is suspended and the operation is executed outside of any transaction
  - `REQUIRES_NEW` If there is an active transaction, it is suspended and the operation is run inside a new one
  - `NESTED` If a transaction exists, a save point is created so if the operation throws an error, it can rollback to that save point. If there is no transaction, it works like `REQUIRED`