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

# Packages and Imports

Packages are a way to organize your classes, interfaces, and enums into a folder structure
- They follow the lowercase naming convention, with words separated by dots, in the reversee way you would call a web domain
- com.example.package

You can access classes by their fully qualified names eg. package.classname

You can use import statements to pull in other classes

After importing the class or package we can just use it in the program
The java.lang package is imported by defaulted

# Operators and Control Flow

## Java Operators

| Operator             | Precedence                              |
| -------------------- | --------------------------------------- |
| postfix              | x++ x--                                 |
| prefix               | ++x --x                                 |
| multiplicative       | \* / %                                  |
| additive             | + -                                     |
| shift                | << >> >>>                               |
| relational           | < > <= >=                               |
| equality             | == !=                                   |
| bitwise AND          | &                                       |
| bitwise exclusive OR | ^                                       |
| bitwise OR           | \|                                      |
| logical AND          | &&                                      |
| logical OR           | \|\|                                    |
| ternary              | expression ? true option : false option |
| assignment           | = += -= /= %=                           |

When we talk about logical AND

true && true = true
true && false = false
false && true = false
false && false = false

When we talk about logical OR

true || true = true
true || false = true
false || true = true
false || false = false

## Logical AND and OR will short circuit
- the operation can determine the outcome by looking at only one side of the expression

## Java Control Flow:

We can break up the normal of an application with conditional/branching statements and loops

Conditional/Branching:
- if/else, if/else if, ternary operators, switch, try catch

Looping Statements:
- for loops, enchanced for loops, while loops, and do-while loops

Conditional Statements run when a condition evalutates to true, or skips if its false

- You can use if statements three ways
    - single if
    - if/else
    - if/else if
- Switch statements can conditionally check the equality of objects/variables
    - They take a variable and attempt to match its content
    - Only work with byte, char, short, int, String, and enums

Loop Statements repeat logic until the loop is finished
- for loops run the logic inside for a set number of times
- while loops runs the logic inside until a condition is false
- do-while loop runs the logic inside of the while loop while a condition is true, expect it will always run at least once

## Break and Continue Keywords

Break can be used in loops, if statements, and switch statements
- It will break out of the current block of code

Continue can only be used inside of loops
- It will break out of the current iteration of the loop, and return to the top of the loop execution

# Variable Scopes

When a variable is declared in Java, it is attached to specific scope within the program, which determines where the variable resides

The different scopes are:
- Instance of object:
    - The variable belongs to an individual object created from a class
    - When an instance varible is modified it has no effect on other objects of the same class
- Class or static scope:
    - The variable belongs to the class itself, every object of that class share this variable
    - When a class variable is modified, the varible in all objects of that class is also changed
- Method:
    - The variable was created inside of a method block, so it is only available inside of that method
    - Will no longer exist after the method has finished
- Block:
    - The variable only exists within a specific block of code
    - A block of code is any code with {}
    - Most typically if/else, for loops, while loops, after these are done executing the variable no longer exists

# Modifiers

There are two types of modifiers, access and non-access

## Access Modifiers:
are keywords that define the ability of other code to access the given entity

There are 4 access modifiers, and they can be placed in front of classes, interfaces, enums and class members

- public: available anywhere
- protected: available within the same package, and this class' sub-classes
- default(nothing): available within the same package
- private: only available within the class

## Non-access Modifiers

There are 7, but we only use 4 often
- static: is the keyword to denote that a class member has class scope, can be used on variables and methods
    - static variables can be accessed through the class eg MyClass.staticVariable
    - static methods can be called directly without needing an of the class, eg. MyClass.someMethod()
- final: is the keyword that makes something unchangable
    - when applied to a variable it cannot be reassigned
    - when applied to a class it cannot be extended
    - when applied to a method it cannot be overriden
- abstract:
    - when applied to a class, the class can no longer be instantiated directly, it must be inherited
    - when applied to a method, the method must not have an implementation, any abstract method must be in an abstract class
- transient:
    - mark a variable as non-serializable, meaning it will not be persisted when written to a byte stream

# Garbage Collection

Java automatically removes objects from memory where there is no longer a reference to it

You cannot explicitly call for garbage collection, but you can suggest it with these methods
- System.gc()
- Runtime.getRuntime().gc()
- System.runFinalize()
    - Finalize is an inherited method from the object class, you can override it to implement some logic to run before you object is destroyed

# Strings and the String Pool

String are **NOT** primitives, they are immutable (state or value cannot be changed once created), constant object derived from the String Class

All String methods return a new String object, the original is not modifed

## String Pool:
a place in memory where strings are placed when created
- This is stored in the Heap
- Duplicate Strings are not allowed
- If a String literal exists in the pool, any new matching String literal will point to the existing String in the pool

If you want to create a duplicate, you can create a new String object that will exist in the heap
- If the string literal being used to create the object does not exist in the pool, it will be added

# StringBuilder and StringBuffer

StringBuilder and StringBuffer allow us to create mutable strings
- Are mutable classes that hold a sequence of characters

They both have methods such as .append() and .insert() which mutates their internal sequence of characters

StringBuilder is not threadsafe, and StringBuffer is threadsafe

# Arrays, VarArgs, and for-each loops

An array is a contigous block of memory storing a group of sequential elements of the same type
- Arrays are of a fixed size, and cannot be resized
- Arrays are declared with square brackets after the data type
- Arrays are referenced via their index inside of the square bracket notation
    - Indexes start at 0
    - There is also a length property that specifies the length of the array

Arrays can also be multi-dimensional, you use multiple square brackets instead one
- This store arrays insides of an arrays, forms a matrix like structure

VarArgs is short for variable arguments, and it is used to set an argument to a method whose size is determined at runtime
- You use the ... notation instead of the array bracket notation
- Java will convert this to an array under the hood, so you access the arguments the same way you would an array
- There can only be one varargs, and it must be the last parameter