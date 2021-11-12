# Hibernate

## Should be in notes, or quick research

1.  What is Hibernate? What is JPA?
-JPA is the java persistence API, Hibernate is an ORM tool for java programming. It allows us to map classes to databases
    
2.  What is the benefit of using Hibernate over JDBC?
-JDBC becomes too complex with bigger applications.
-Hibernate supports dual level caching which is very scalable
-hibernate is database independent
    
3.  Tell me about some of the JPA annotations you have worked with? What do they do? How do you specify multiplicity relationships with JPA annotations?
@Entity to mark as a table in database
@Table 
@Id
@column
@GeneratedValue
@OnetoOne, @OnetoMany, @ManytoMany for multiplicity relationships
    
4.  What are the interfaces of Hibernate?
-Configurable (class)
-SessionFactory
-Session
-Transaction
-Query
-Criteria
    
5.  Tell me how you set up hibernate? What files are you editing, what goes in them, etc.
-Hibernate.cfg.xml or Hibernate.properties
-Here you specify the url from your database, the name, username and password.
-You are mapping classes
-You can specify the Dialect for database
    
6.  What ways are available to you to map an object to database entities in Hibernate?
-Using annotations
-Using an XML mapping file (Hibernate.cfg.xml) using the mapping tag <mapping class="com.example.app.Student">
    
7.  In the session interface, what is the difference between save and persist methods? get and load methods? Update vs merge methods?
    -Save is for creating a new transient object to push to the table, while persist is to update an existing transient object
    -Get returns a null while load throws an exception when they point to an empty object
    -Update is used when the session is flushed, but if you are not sure about the sessions state then use merge, which saves modifications no matter what state session is in

8.  What are the different session methods?
-Create: save(), persist(), saveOrUpdate()
 Read: .get(), .load()
 Update: .update(), .merge()
 Delete: .delete()
    
9.  What is the difference between Eager and Lazy fetching and how to setup either?
    -"Eager Loading is a design pattern in which data initialization occurs on the spot. Lazy Loading is a design pattern which is used to defer initialization of an object as long as it's possible."
    -Eager gets loaded no matter what right away
    -Lazy waits until it gets called/invoked
    -FetchType.LAZY
    -FetchType.EAGER

11.  What are the 4 ways to make a query using Hibernate?
-HQL
-Native SQL
-JPQL
-Criteria API
    
12.  What is HQL? What makes it different from SQL?
-Hibernate Query Language
-Allows you to query against persistent objects instead of tables and columns
-Helps decouple your code from the database
    
14.  What is caching? What is the difference between L1 and L2 cache?
    -Caching is what helps us optimize the performance of our applications
    -L1 is the first place hibernate looks for data, if data is not there than hibernate looks in L2
    -L1 automatically implemented hibernate
    -L2 is optional, you use a third party library

15.  How do you enable second level caching?
-You have to edit the hibernate.cfg file with the following:
-<property name="cache.use_second_level_cache">true</property
-<property name="hibernate.cache.region.factory_class">pathforcacheclass</property>
    
16.  Tell me about NamedQueries.
-Named queries are a SQL expression with a predefined unchanged query string
-They can be defined in the entity class or the mapping file
-some annotations are : @NamedQueries @NamedQuery @NamedNativeQuery
    
17.  Can you write native SQL with Hibernate? Is this a good idea?
    -Yes you can it allows you to use database specific queries
    -it is not recommended because it tightly couples your code with the database

18.  What are the configuration options for Hibernate?
-Either using hibernate.cfg.xml or hibernate.properties
    
*  How to specify the SQL dialect?
<property name = "hibernate.dialect">org.hibernate.dialect.MySQLDialect</property> in the hibernate.cfg.xml file
    
*  What data must be specified for the SessionFactory?
-We need to establish the database connection using url, username and password.
    
*  What is hbm2ddl?
-this is used to create, update or validate the database schema DDL when the SessionFactory Object created

19.  How would you configure Hibernate to print to the console all SQL statements run?
    
20.  What are the different object states in Hibernate? What methods move objects to different states?

## Extra Research Required

10.  Under what circumstances would your program throw a LazyInitializationException?

13.  What is the Criteria API? Can you perform all DDL and DML commands with it? How do Restrictions and Projections work within this API?

21.  What is a proxy? When does the proxy resolve to the real object?

22.  What is the difference between Dynamic Insert and Dynamic Update?

23.  What is automatic dirty checking?
    
24.  What is Transactional Write Behind?
    
25.  Explain how transaction propagation works
