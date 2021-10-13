# OOP in JS

Object Oriented Programming Principles
- Abstraction
- Polymorphism
- Inheritance
- Encapsulate

Javascript has prototypical inheritance:
- All Javascript objects have a prototype. This is implemented through `__proto__` property
- This property is used to define inheritance
- An objects `__proto__` property can be set to reference another object, this will make that referenced object the parent of the object that references
- The top prototype of all objects is Object.prototype. This is the value assigned to `__proto__` by default

Javascript uses closures for encapsulation

Polymorphism occurs during type coehercion

Java uses classes for abstraction

- Classes were introduced in ES6 as ways to create object templates, which allow us to create multiple objects with similar attributes
- It also allows us to take advantage of inheritance through the extends keyword
- Javascript even implemented the static keyword, which creates field or functions that belong to the class itself
- Classes have special methods called constructors that you can tell it how to you want new objects from this class to be created

# Modules

We can export and import peices of our Javascript code to and from different script files

- You use the export statement to create a module
- You use the import statement to use a module
- We will see this used a lot when we reach frontend frameworks

# Template Literals

Template literals are an easy way to create multi-line strings and perform string interpolation

- Template literals are Strings that are enclosed by backticks `
- It allows for embedded expressions, placeholders indicated by a dollar sign and curly braces `${expression}`
- These expressions can be used to evaluate

# OOP Hands on, crate a JS class that models a car, then create a child class of specific car class, have fun and be creative