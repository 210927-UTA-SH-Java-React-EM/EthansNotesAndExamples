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