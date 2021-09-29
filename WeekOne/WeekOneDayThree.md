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
- Which method runs is determined at run-time, making it run-time polymorphism

Method Overriding:
- A method in a child class hase the same name as a method in the parent class, but a different implementation
- Makes class hierarchy more flexible and dynamic
- Compile-time polymorphism because of virtual method invocation
- Virtual Method Invocation will look at the reference objects type and call the method associated with that object

Method Hiding:
- When a child class implements the same static method as its parent. The parent method is replaced by the child class' method

Covariance Return Type:
- When overriding a method, you can change the return type as long as it is a subclass of the original return type
- You can change the access modifer as long as it is not more restrictive

## Casting

Upcasting allows you to assign a child object to a parent object, this works because the child will have all of the behaviors of the parent, however you may be missing some of the childs functionality

Downcasting is the opposite, it allows you to assign a parent object to a child object, however you cannot garentee that the parent object will have all the properties of the child, leading to problems