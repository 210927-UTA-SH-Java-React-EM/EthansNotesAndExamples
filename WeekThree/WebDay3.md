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

# Spread Operator and Rest Operator

Both were introduced in ES6

## Spread Operator
used to combine arrays, it expands the content of an array into individual elements

## Rest Operator
used as a way to pass in mulitple arguments, or in other words, the implementation of var args

# Destructuring Assignment
used to destructure an object or an array, and store the unpacked values into variables
- you can destructure arrays based on their indexes
- when destructuring arrays you use square brackets
- you can destructure objects based on their atttributes
- when destructuring objects you use curly braces

# Enhanced Object Literals:
ES6 made creating objects easier and more dynamic
- if you have a key and a variable name that are the same, you can simply use the single key
- you can dynamically set the name of a key with square brackets and the name of the variable with the value of the key ex. [valname]: "value"
- when creating a function in an object, you no longer need to give it a key value pair, just create the method

# Errors

When something goes wrong in Javascript an Error Object is created, there are two ways this can occur

1. Runtime error: an error that is created as a result of something went wrong in the code
2. User defined error: an error built as part of your code to represent a problem that can occur.
    - These user defined errors can have many fields depending on implementation, the standard ones are name and message

## Handling Errors

You can handle an Error in Javascript with a try catch block
- Surround the at risk code in a try block
- If something occurs, we can handle the Error in the catch block. Similar to Java

## Throwing Errors

If you want to throw an error yourself, you can use the `throw` keyword
- You can actually throw anything in Javascript, but somethings wouldn't make much sense

## Custom Errors in Javascripts

There are two ways to cerate a custom error in javascript

1. Create a new function with a name and message field, set the prototype of the object Error
2. Create a class that extends Error, and pass in a message to the parent constructor using the super keyword

