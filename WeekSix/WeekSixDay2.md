# Annotations for Model Classes

There are two ways to map a class to a database table in hibernate
- Using annotations
- Using an XML mapping file

It is a more modern approach to use Class annotations, because you have less xml files in your project, and it makes your project easier to follow

Hibernate annotations provice a nice easy way to define mappings directly in your POJO classes without the use of XML files

Hibernate annotations are based on JPA 2 specifications, so you should be using the annotations that are defined in the javax.persistance package

A list of common annotations:

- `@Entity` : used to mark a class as a Mapped class/ Persistence class. This class must have a no-arg constructor with package visibility so that hibernate can create an instance of the persistence class by the `newInstance()` method

- `@Table` : Used to specify the table details that are used to persist the entity in the database. If the name of the database table differs from the name of the class, the name attribute should be used.

- `@Id` : Used to mark the field as a primary key column. Annotating multiple fields with @ID will make them composite keys

- `@GeneratedValue` : Used to instruct the database to generate a value for the field automatically, and to provide a strategy for doing so

- `@Column` : Maps the field to the table column. @Colum annotation has attributed that are listed below:
    - `name` : used to specify the name of the column, by default its assumed the column name and variable name match. This attribute is required only if that is not the case
    - `length` : used to specify the size of the string value
    - `nullable` : used to mark the column as either nullable or not nullable
    - `unqiue` : used to mark the column as unique

