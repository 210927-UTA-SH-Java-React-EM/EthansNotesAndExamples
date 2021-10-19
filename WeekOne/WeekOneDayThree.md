# Pillars OOP

There are four pillars/principles of object oriented programming that can be remembered by the accronym APIE

- Abstraction
- Polymorphism
- Inherhance
- Encapsulation

## Inheritance

Inheritance is where a base class (or parent class) passes traits/behaviors down to a sub-class (child class)

- This create a parent-child or an is-a relationship between two classes

In Java all non-private fields and methods are inherited from a parent class by using the keyword extends in the class declaration

Inheritance is useful because:
- It allows code to more reusable and modular
- It helps avoid boilerplate code, helping us abide by the programming guide of DRY (Dont Repeat Yourself)

In Java you cannot have multiple inheritance
- One class can only ever extend one other class
- This is because two different classes can have the same method, and the subclass would not know which implementation to use

Classes in Java are allowed to implement any number of interfaces
- Mutli-level inheritance is possible through the use of interfaces
- This is because interfaces don't care what implemenation you give them, as long as the method is implemented in the subclass

![inheritance](types_of_inheritance.jpg)

## Shadowing:
the practice in Java programming of having two variables with the same name within scopes that overlap
- When a parent and child share the same variable, the childs variable will shadow the parents

## Abstraction

Is a programming principle in which we centralize common characteristics and generalize behavior into conceptual classes
- hiding the underlying complexity through a simplified interface, while still allowing the user to know its methods

In Java abstraction is done through abstract classes and interfaces

## Abstract Classes

Are more general classes than cannot be instantiated, they act as a template for other classes to inherit from

Abstract classes are created with the `abstract` keyword, and they can contain both concrete and abstract methods

## Interfaces

Are "contracts" for methods that classes must implement, they also cannot be instantiated

Interfaces are implicitly public and abstract
- Every method in an interface is public and abstract
- Interfaces can have variables, they will implicitly be public static and final
- In Java 8 default methods were added, which allows programmers to implement methods inside of interfaces

To inherit from an interface a class must use the `implements` keyword in the class declaration

## Polymorphism

Polymorphism is the ability for an object to take on many forms

The most common ways this is achieved is:
- Method overloading
- Method overriding
- covariance
- casting

Method Overloading:
- Two or more methods exist with the same name, but have different method signatures by changing the number of parameters, the types of parameters, or the order in which the parameters are passed
- The return must stay the same
- Because the argument list is known at compilation, the compiler knows which version of the method will be executed. Therefore, method overloading is a type of compile-time - or static - polymorphism

Method Overriding:
- A method in a child class hase the same name as a method in the parent class, but a different implementation
- Makes class hierarchy more flexible and dynamic
- Run-time polymorphism because of virtual method invocation
- Virtual Method Invocation will look at the reference objects type and call the method associated with that object

Method Hiding:
- When a child class implements the same static method as its parent. The parent method is replaced by the child class' method

Covariance Return Type:
- When overriding a method, you can change the return type as long as it is a subclass of the original return type
- You can change the access modifer as long as it is not more restrictive

## Casting

Upcasting allows you to assign a child object to a parent object, this works because the child will have all of the behaviors of the parent, however you may be missing some of the childs functionality

Downcasting is the opposite, it allows you to assign a parent object to a child object, however you cannot garentee that the parent object will have all the properties of the child, leading to problems

## Encapsulation

Restricting direct access to data, while providing indirect access to it through separate methods

You achieve encapsulation by making data members private, and creating public getters/setters for them

# SOLID Design Principles

Set of principles that are used in conjuction with OOP

Single Responsibility:
- A class should only have a single responisibility, only one part of the software should be affected by a single class

Open-Closed Principle:
- Software entities should be open for extension, but closed for modification. Classes should be able to have their behavior extended without being modified

Listkov Substitution Principle:
- The objects in a program should be replaceble with instances of their subtypes without altering the correctness of the program

Interface Segretation Principle
- Many client specific interfaces are better than on general purpose interface

Dependency Inversion Principle:
- One should depend upon abstraction, not concretion
- This will be huge in Spring Week

# Object Class

In Java the object class is the root of all classes, all java classes inherit from the object class

Therefore all classes in Java will have these methods defined by the object class:

-   Object clone()
-   boolean equals(Object o): by default this will perform == on the objects memory location, you can override this to compare other parts of the object
-   void finalize(): this is called by the garbage collector when it determines there are no more references to the object
-   Class<?> getClass()
-   int hashCode(): returns an int indicating the hashcode, this one has a few rules
    -   If you override equals() you are also expected to override hashCode()
    -   The result of hashCode() should not change in a program
    -   if .equals() returns true the hashcode should be the same
    -   if .equals() returns false, the hashcodes do not have to be distinct
-   void notify()
-   void notifyAll()
-   String toString(): this will be called automatically if you try to print the object, typically you want to override this method otherwise it will print the fully qualified class name
-   void wait()
-   void wait(long timeout)
-   void wait(long timeout, int nanos)

# Wrapper Classes

For every Primitive in Java, there is a wrapper class with the same name but capitalized
- These allow you to treat primitives as objects

The Wrapper Classes include:

| Primitive | Wrapper Class |
| --------- | ------------- |
| boolean   | Boolean       |
| byte      | Byte          |
| short     | Short         |
| char      | Character     |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |

Autoboxing: when you pass a primitive argument into a parameter that asks for its wrapper equivalent, Java will automatically wrap the primitive into its object type

Unboxing: when you pass a wrapper object into a parameter that asks for a primitive, Java will automatically convert the object to a primitive

# Annotations

Annotations are special constructs in Java which use the @ symbol followed by the name of the annotation
- Annotations provide metadata about the source code to the compiler and JVM

Annotations can be placed over classes, methods, interfaces, and other constructs

Annotations are often used by libraries to abstract funcionality, or enforce some set of rules
- Annotations are ofect processed by the Reflections API

Some examples include:
- @Override
- @Deprecated
- @SuppressWarnings
- @FunctionalInterface

# Intro to TDD and Unit Testing

Test Driven Development (TDD) is a the process of writing tests for your code, then implementing the code to pass those tests

- This helps increase code coverage

The process can be broken down into 5 steps

1. Write a unit test
2. Run the test (it will fail)
3. Write code to pass the test
4. Retest, until the test passes
5. Repeat the process

Unit Testing: is the testing of individual software components in isolation from the rest of the software

It cal also be known as White Box testing:
- a testing method in which the internal design of the item being tested is known to the tester

Unit testing can find if/where something goes wrong in your code

- This helps reduce debugging time because you know where to look for the issue in the code
- It also increases code coverage, because you should be testing each individual unit/module of code
- It increases confidence in changinf and maintaining your code base

It is best practice to include both positive and negative test cases

# JUnit and Mockito

## JUnit: is a Java framework for unit testing

It uses annotations to create tests and setup testing enviornments

-   `@Test` - declares a method as a test method
-   `@BeforeClass` - declares a setup method that runs once, before all other methods in the class
-   `@Before` - declares a setup method that runs before each test method
-   `@After` - declares a tear-down method that runs before each test method
-   `@AfterClass` - declares a tear-down method that runs once, after all other methods in the class

JUnit also has built in methods to use in your testing methods to verify the state of the application is what is expected:
- `assertTrue()`
- `assertFalse()`
- `assertEquals()`
- `assertNotEquals()`
- `assertThat()`

## Mockito: is Java framework that allows us to mock the functionality of other methods

- This allows for black box testing:
    - Where you don't know the functionality of a given item, we just need the output
- This is extremely useful for testing methods that rely on the output of other methods
- You replace the depedency of the other method with mocks and stubs

A stub is a fake class that comes with preprogrammed return values

A mock is a fake class that can be examined after the test is finished to see how it interacted with the class under the test

# Exceptions

Are events that occur during the execution of a program that disrupts the normal flow, during these events an Exception object is thrown
- You can recover from exception if you handle them

## Exception Hierarchy

The root of all exceptions is the Throwable class
- Any class that extends this Throwable class is able to be "thrown" with the `throw` keyword

The Exception class and Error class that both extend Throwable

RuntimeException that extends Exception

From there, all exception extend either from the Exception or RuntimeException class

![Exceptions hierarchy](https://i.pinimg.com/originals/a6/ab/f3/a6abf35c5fbbb57ebd4e949945839f31.jpg)

## Checked and Unchecked Exceptions

Checked exceptions are caught at compile time, and they are required to be handled by the programmer, otherwise your code will not run

- In the hierarchy these are the classes NOT extending RuntimeException

Examples:
- FileNotFoundException
- ClassNotFoundException
- CloneNotSupportedException

Unchecked Exceptions are caught during run-time, are not required to be handled by the programmer
- In the hierarchy these are any exceptions that ARE a subclass of RunTimeException

Examples:
- ArithmeticException
- IndexOutOfBoundsException
- NullPointerException

In Java there are also objects called Errors, these occur when something goes carstrophically wrong, and cannot be recovered from

Examples:
- StackOverflow
- OutOfMemory

## Exception Handling or Declarations

When you suspect that code may be at risk of throwing exception, it can be handled in two ways

1. You place the code inside of a try/catch block
2. You can declare the method could throw an exception with the `throws` keyword
- Declaring it on the method will "duck" the exception, which hands the responisibility of handling the exception to which every entity called the exception

## try/catch/finally blocks:

You want to enclose the code that is suspect to throw an error inside of the try block of code

Inside of the parenthesis of the catch block, you should declare the exception that you are expecting to catch, and whatever logic should run if the exception occurs

The finally block will run regardless of the out of the try block

try/catch rules and multi-catch blocks
- Multiple catches are allowd, but they must go from most specific to least specific
- You can catch more than one exception per catch block using ||
- The finally is optional
- A try/finally block is legal, but a try block on its own is not

You can cause an exception yourself by using the `throw` keyword

## Custom Exceptions

You can also create your own custom exceptions
- You can create checked exceptions by extending the Exception class
- You can create unchecked exceptions by extending the RuntimeException class

Which one you choose depends in whether you want to force the programmer to handle the exception

**Know the different between throws, throw, and throwable**

# Collections API:
The Collections API is a framework of Java classes and interfaces that implement commonlyu used data structures

## Data structure:
a data organization, management, and storage format that enables effiecient access and modification
- Each one prioritizes access and modification in different
- Typically one is better for specific tasks for others

There are two different types of data structures:

- Linear: arranged in an orderly manner where each element is attached adjacently
    - Elements can ve access in one time single run
    - Simplier to implement
    - single level
    - Memory inefficient
- Hierarchical: arranges elements in a sorted order, adn there is a relationship between them
    - Cannot be accessed in a single run
    - Complex to implement
    - Multi-leveled
    - Memory Efficient

![Collection API class hierarchy](https://javaconceptoftheday.com/wp-content/uploads/2014/11/CollectionHierarchy.png)

**ALMOST** every class in the collections api extends from the Iterable interface
- Exception is the Map classes

# Iterable Interable and Iterator Interface

## Iterable Interface:
defines data structures that can be directly traversed using the .iterator() method

## Interator Interface:
contains methods for traversing linear data structures, these methods include:
- hasNext()
- next()
- remove()

Any class that implements Iterable can also be used with enhanced for-loops

Classes that implement the Iterable interface also have the .forEach() each method, which allows user to iterate through the data structure, and perform some logic with a lamda expression

# Lists
The most basic datatype, a collection of ordered data that is preserved
- Duplicate entries are allowed
- Elements are accessed by their index, which start at 0

ArrayList: a concrete implementation of the List interface that contains an array within it
- The array is resizable, once it reaches the max capacity it increases its size by 50%
- You can traverse it quickly via index
- Insertion and deltion is slower, because it may have to resive the internal array

LinkedList: a concrete implementation of the List and Queue interface which is composed of nodes that reference each other
- Insertion and deletion is relatively quick
- Traverse to a specific index is slower

Vector: an older concrete implementation of the List interface, which is a threadsafe arraylist
- Doubles in size if needed

Stack: an older concrete implementation of the List interface, used to implement the stack data structure, (first in last out), but you should now use ArrayDeque

# Sets
A collection of data that is not ordered and does not allow duplicate elements
- does not preserve the order in which elements are inserted

HashSet: a concrete implementation fo the Set interface backed by a HashMap
- There is no ordering when iterating
- Allows one null value
- Allows fast insertion and traveral

TreeSet: a concerete implementation of the Set interface which maintains sorted order when elements are inserted
- It is backed by a Sorted Tree
- Insertion and deletion is slow
- It cannot contain null elements

# Queues
Collection of data that follows first in first out, unless otherwise specified

ArrayDeque: a concrete implementation of the Queue interface that allows programmers to implement stack or queue behavior
- It is a double ended queue
- It stores items in a resizable array

Useful ArrayDeque methods:
- pop()
- push()
- peekFirst()
- peekLast()
- pollFirst()
- pollLast()
- offerFirst()
- offerLast()

Priority Queue: a concrete implementation of the Queue interface which orders elements based on their natural ordering
- It uses a Comparator to order the elements

# Maps
Data structure that uses key/value pairs to store and retrieve data

The Map interface does not implement the Collection Interface, however it is still considered to be part of the Collections API

Youn cannot iterate over a Map, because it does not implement the iterable interface, you can iterate through different values in a Map:
- use the entrySet() method to iterate over the set of Map.entry
- use keySet() method to iterate over the set of keys
- use values() method to return a Collection of values which then can be iterated over

HashMap: a concrete implementation of the Maps interface that:
- Stores elements in a key/value pair
- Insertion and retreival is fast
- Tradeoff is that it does not maintain insetion order
- Permits on null key and null values

TreeMap: a concrete implementation of the Maps interface that:
- Stores its keys in a sorted tree structure
- Insertion and retrieval is slow
- Cannot contain null keys

HashTable: older concrete implementation of the Maps interface that is threadsage, and cannot contain null keys or values

# Comparable and Comparator Interfaces

## Comparable:
an interface which defines the natual ordering for a class
- The class must implement the Comparabl interface and implement the compareTo() method

The compareTo() method should return:
- Zero id the two object are equal
- Less than zero if "this" object is smaller than the one in the parameter list
- Greater than zero is "this" object is larger than the one in the parameter list

## Comparator
an interface that allows you to define a total ordering on some collection of objects
- You can implement the Comparator interface, but are not required to implement the .compare() method

# collections vs Collection vs Collections

- collections are just a collection of entities
- Collection: is an interface within the Collection API
- Collections: is a utility class that has static, conveient methods that operate on data structures in the Collections API