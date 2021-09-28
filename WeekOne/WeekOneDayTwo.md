# Intro to Java

## Java is a programming language that is:

High-leveled: Easy to read syntax, automatic mem management, garbage collection

Compiled: Progams are converted or compiled into Byte Code

Strongly Typed: Variables types must be defined at compile, and cannot be assigned

Object Oriented: Has constructs of classes and objects built in that allows programmers to follow the principles of Object Oriented Programming

## Advantages of Java (why we like to use it):

Java is platform idependent, you write once and run anywhere, this due to the JVM

It is widely popular with a rich API and countless libraries

It is Object Oriented

It has simple syntax to learn, based on the C programming language

It is free, and supported by Oracle

Has automatic mem management, and garbage collection

# JDK, JRE, JVM

## Java Development Kit (JDK):

This provides developer tools to develop Java Applications, it comes with:
- The JRE
- Debugger
- Devtools
- Compiler

## Java Runtime Environment (JRE):

This provides the build in libraries that Java needs to run code, it comes with:
- the JVM
- all neccessary libraries to run java code
- it is the minimum requirement to run a Java program

## Java Virtual Machine (JVM):

This converts your Java Byte Code into machine readible code
- This is OS specific
- Includes the Classloader, runtime data area, execution engine, and heap and stack area

# Java Primitive Data Types

The only thing keeping Java from being completely Object Oriented,

The primitives include:

| Datatype 	| Size                             	| Values                                    	|
|----------	|----------------------------------	|-------------------------------------------	|
| boolean  	| 1 bit                            	| true or false                             	|
| byte     	| 8 bit integer                    	| -128 to 127                               	|
| short    	| 16 bit integer                   	| -32768 to 32767                           	|
| int      	| 32 bit integer                   	| ~ -2 billion to 2 billion                 	|
| long     	| 64 bit integer                   	| -2^64 to 2^64-1                           	|
| float    	| 32 bit floating point            	| -3.40252357 x 10^34 to 1.40239846 x 10^-45 	|
| double   	| 64 bit floating point            	| -1.7976... x 10^308 to 4.9407... x 10^-324 	|
| char     	| 16 bit unicode character         	|                                           	|
| String   	| Not a prim, but treated like one 	|                                           	|

## Data type Default value

- boolean: false
- char: \u000 (0)
- int: 0
- float: 0.0f
- reference types (objects): null

## Datatype casting:

Widening: Will occur automatically, Java will convert a smaller data type to a larger type

Narrowing: Will need to be done manually, converting a larger data type to a smaller data type

# Classes vs Objects

## Objects in Java

An object is a virtualization of a real world object

Created from a class, and hold states, behaviors, and indentity

States: property attributes (fields)

Behaviors: methods (a function that is attached to an object)

Identity: the name of the object

## Classes in Java
A class is a blueprint for an object
- It will contail all of the properties and methods that the object will have

## Modularization

Writing code that is available/reusable in different places
- Break up the code into smaller reusable pieces
- We use Classes and objects to achieve this
- Allows us to simplify our code

# Methods and Parameters

## Methods are blocks of code which only run when called
- Declared inside of classes, they must have a return type, name, and parameter list followed by curly braces

`return type name(params, param2, param3, so on and so forth){}`

## Parameters are specified inside of the parenthesis of the method

There is a special method called `main`, it is where the program execution occurs
- There is only one per "program"

## Pass by Value vs Pass by Reference

Java uses pass by value when passing variable to methods
- This means a copy of the value is passed into the method, and original is not modifed

![pass-by](https://blog.penjee.com/wp-content/uploads/2015/02/pass-by-reference-vs-pass-by-value-animation.gif)


Java objects appear like they are pass by reference, however they are still pass by value

# Stack and Heap

Inside of the JVM, our application memory is divided into the stack and the heap

The heap is allowed memory space for the application
- The amount is allocated from machine to machine, we cannot control it
- Inside of the heap there is the stack, and object
- The `new` keyword will make a new instance of an object, the variable will point to the object in memory
- You can run heap space causes an OutOfMemoryError

The stack is where method invocations and reference variables are stored
- When a method is called it gets put at the top of the stack and gets executed
- You can run out of stack space, causes a StackOverflowError

![heapvsstack](https://cdn.journaldev.com/wp-content/uploads/2014/08/Java-Heap-Stack-Memory.png)

# Constructors:
are special methods that declare how an object is to instantiated and initialized from classes
- do not have a return type
- return a new object

Three types:
- default: gets created automatically if no other constructor is given
- argument: is a constructor that takes in parameters
- no-arg: is a constructior that takes in no parameters

We use the `this` keyword typically to set a variable that belongs to the specific class/object

We use the `this()` keyword inside of the constructor to call another constructor inside of the class

We use the `super()` keyword to call the constructor of the parent class, a call to `super()` is implicitly the first line of every constructor
- It MUST be the first line