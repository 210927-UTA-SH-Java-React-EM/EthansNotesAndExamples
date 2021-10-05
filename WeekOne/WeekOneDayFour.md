# Generics

Generics are constructs introduced in Java 5 which enforce compile time type safety by allowing you to use parameterized types
- They are used heavily with the Collections API

They are essentially a place holder for a future datatype that helps us enforce type safety

Generics can be declared on a class, method parameters, or return types

With Generics you can restrict a class to only accept objects of a given type and the compiler will prevent you from using any other types

To make a class or interface generic, use angled brackets when declaring it, and use an arbitrary "generic type" which is determined by invoking the code

Naming conventions for Generics

- E => Element
- K => Map Key
- V => Map Value
- N => Number
- T => Generic Data type
- S, U, V and so => For multiple generic data types

# Threads and Concurency

Concurency refers to breaking up a task into different parts that can be executed independent of one another, in any order without affecting the final outcome

## Threads:
a thread is a subset of a process that is also an independent sequence of execution

- Threads of the main process wil run in the same memory space, but managed independently by the scheduler

Every thread has its own call stack where it stores local variable references, but since they share the same heap memory multiple threads can access the same objects in memory

Mutlithreading is the idea of using multiple threads in an application to achieve parallelism
- Each thread can perform its own task increasing effiency

In Java we achieve multi-threading with the Thread class and the Runnable interface

In general it is best practice to not attemp to implement multithreading on your own, because it can lead to issues we will speak about later
- You are encouraged to use frameworks and api's that implement it for you

# States of Threads

Threads follow a lifecycle with six different states:

1. New: newly created thread that has not started executing
2. Runnable: either running or ready for execution but waiting for its resource allocation
3. Blocked: waiting to acquirea monitor lock to enter or re-enter a synchronized block/method
4. Waiting: waiting for some other thread to perform an action
5. Timed_Waiting: waiting for some other thread to perfom a specific action for a specific time
6. Terminated: has completed its execution

![Thread lifecycle](https://www.javatpoint.com/images/thread-life-cycle.png)

Threads also have priorities which signify which order that should be run. The thread class contains a few static variables for priority

- MIN_PRIORITY = 1
- NORM_PRIORITY = 5, default
- MAX_PRIORITY = 10

# Custom Threads

You can create your own custom threads in one of two ways, extending the Thread class, or implementing the Runnable interface

## Thread Class

Creating a thread with extending the Thread class will grant you access to the thread classes methods:
- getters and setters for id, name, and priority
- interrupt() to explicitly interupt the thread
- isAlive, isInterrupted, and isDaemon to test the state of the thread
- join() to wait for the thread to finish executing
- start() to actually begin the thread execution after instatantion

To create a thread this way:
1. Create a class that extends Thread
2. Implement the run() method
3. Use the custom thread with the .start() method

## Runnable Interface

Creating a thread with implementing the Runnable interface will give you the freedom to extend any different class of your liking

To create a thread in this way:
1. Create a class that implements Runnable
2. Implement the run() method
3. To use this thread you must create a generic thread object and pass your custom runnable object as a parameter to the constructor

# Thread Problems

There are issues that can occur if you try to implement multithreading yourself. Once of these is called Deadlock

Deadlock occurs when two or more threads are blocked trying to access the same resource, waiting for one another. Neither thread can continue execution, so the program halts indefinitely. This it where Synchronization comes in

Synchronization is the capability to control the access of multiple threads to any shared resource

To do this we use the `synchronized` keyword. The synchronized keyword enforces that only one thread can access the resource at a given time

Another problem multithreaded programs run into is the producer consumer problem

# Producer Consumer Problem

In this problem we have a fixed size buffer that is shared between the producer and the consumer
- The producer adds to the buffer
- The consumer takes from the buffer

The proble is that data should only be added if the buffer is not full, and data should only be consumed if the buffer is not empty

To solve this we can use the synchronized keyword, as well as the .wait() and .notify() methods to communicate across threads
- .wait() can pause the consumer depending on the amount of data in the buffer
- .notify() can send a notification to either thread when they can be used

# POJO vs Bean

A POJO is a Plain Old Java Object

A Java Bean is a special Java Object with specific rules:

- All Java Beans are POJO's but not all POJO's are Java Beans
- They must be serializable, ie implement the Serializable Interface
- All fields should be private
- Fields should have getters and setters
- There should be a no-args constructor
- Fields are accessed only by constructors and getters and setters

# Serialization
the process of writing the state of an object to a byte stream, the reverse is called deserialization
- We serialize Java Beans

## Marker Interfaces
- An interface with no methods, its purpose is to provide metadata to the compiler
- Serlializable is a marker interface, it tells the compiler the object can be serialized

# File I/O

"I/O" refers to how data is accessed, either via reading or writing. In Java file I/O objects fall into two categories:

- Streams: reading or writing bytes
- Reader/Writer: read or write characters

Common File I/O classes:

- FileInputStream - reads raw bytes from a file
- FileOutputStream - writes raw bytes to a file
- FileReader - reads characters from a file
- FileWriter - writes characters to a file
- BufferedReader - reads a file line by line, needs an instance of FileReader with a path to the resource to be read
- BufferedWriter - writes to a file line by line, needs an instance of FileWriter with a path to the destination file in the constructor
- Scanner - can read from an InputStream, useful for character reading

Character files are read line by line, indicated by a newline character (\n) or a carraige return (/r)

You always want to be sure to close your resources when you are done reading/writing

The way you serialize data is with a FileOutputStream and an ObjectOutputStream

The way you deserialize is with a FileInputStream and an ObjectInputStream

# Scanner

The scanner class can be usedf to read user input from the command line

# Try with resources

Java 7 implemented a new use for the try catch block, try with resources allows you to add a resource in the try block, and Java will automatically close the resource for you when you are finished using it

The only catch is that the object in the try parenthesis must implement the AutoCloseable interface

# Java 8 Features

Java 8 implemented many new and useful features including:

- Functional Interfaces
- Lamda Expressions
- Stream API
- Reflections API
- Date and Time API
- Optional Classses
- Predicates

# Functional Interfaces

Functional interfaces are interfaces with only one abstract method
- Implicitly created by lamdas
- Can explicitly be created for use by lambdas

# Lambdas
possibly the biggest addition to Java 8, they introduce important aspects of functional programming, allow for dismebodied methods, aka functions

The basic syntax is `paramters(s) -> expression`

For multiple paramaters parenthesis are required, for multiple lines of logic in the expression curly braces

The return keyword is optional

# Stream API

The Stream API is a function-style of defining operations on a stream of elements

- Streams are an abstraction which allow defining operations which do not modify the source data, and are lazily loaded

Streams do not store data, they simply operate on data, like filtering, mapping, or reducing it

Streams are divided into two types:
- Intermediate, return a new stream and are always lazy, they don't execute until the terminal operation is called
- Terminal, trigger the execution of the stream pipeline, which allows effenciency by performing all operations in a single pass over the data

Reduction operations take a sequnce of elements and combine them into a single result
- .reduce() and .collect() are implemented by many Stream classes for this purpose

Example:
```java
List<Student> students = new ArrayList<>();
// add students...
List<Double> grades = students.stream()
                          .filter(s -> s.isAttending())
						  .mapToDouble(s -> s.getGrade)
						  .collect(Collectors.toList());
```

## Reflections API

Allows you to to modify the behavior of methods and classes at runtime

The required classes are provided under the java.lang.reflect

Give us information about the class, including methods names, method return types, and even which annotaitons are used in the class
- This is typically used in Frameworks, and in JUnit to detect the @Test annotations

## Optional Class:

The optional call was introduced to reduce the need for excessive null value checking

An Optional is a wrapper object which may or may not contain a value which a few helpful helper methods

They are useful as replacements for null values when returning an empty response from a method

Example:

```java
public class OptionalExample {
  public Optional<String> getAmbiguousString(boolean b) {
    if (true) {
	  return Optional.of("awesome string!");
	} else {
	  return Optional.empty();
	}
  }

  public static void main(String[] args) {
    Optional<String> optString = getAmbiguousString(false);
	String theString = optString.orElse(""); // specify a fallback value
	System.out.println(theString);
	// we can use the String without fear of NullPointerException now
  }
}
```

## Date and Time API:

Before Java 8 Dates and Times were separate, represented by the java.util.Date and java.util.Calendar, and there were issues with these classes

Java introduced a new API through the java.time package which includes:
- LocalDate - only contains date information
- LocalTime - only contains time information
- LocalDateTime - contain date and time information
- ZonedDateTime - for working with timezones
- Period - represents a quantity of time (year, months, days)
- Duration - represents a quantity of time (seconds, nanoseconds)
- DateTimeFormatter - for representing dates/times in a given format

## Predicate

A Predicate is a functional interface that returns a boolean

# Creational Design Patterns

Creational Design patterns are meant to solve commonly occuring software development problems

## Singleton:
a design pattern which allows the creation of an object only once in an application
- This object is then shared across mulitple classes
- Useful for things like data base connections, or other services

## Factory Design Pattern:
design pattern that creates objects in which the precise type may not be known until runtime

