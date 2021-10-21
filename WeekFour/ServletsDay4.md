# NodeJS

NodeJS is an open-source, cross platform, run-time environment for Javascript built on Chromes V8 engine
- It is NOT a programming language
- It is a run-time environment that allows you to run Javascript code outside of the browser

npm or Node Package Manager is a package manager for the Javascript Programming language. It is the default package manager for the Javascript environment

npm consists of three components:
- the website: discovers packages, setup profiles, and manage access to packages
- CLI runs from the terminal and allows us to interact with npm
- the registry is a public database of Javascript packages

We use Node and npm as tools for building React Applications

# package.json

When you create a Javascript project with node, it automatically creates a package.json in the root directory of the project

The package.json holds information or metadata about the project, including:
- description
- version
- license information
- author
- entry point
- dependencies
- scripts

There are two types of dependencies in the package.json
- dependencies: are essential to running the application
- devDependencies: are dependencies that are only being used during development of the application

To create a node project use `npm init`

## Other useful npm scripts/arguments

- `npm init` will create an new node project
- `npm install packagename` will install any packages listed/described
- `npm i packagename`
- `npn install -g packagename` will install a package globally
- `npm install -D packagename` will install a package as a dev dependency

# Typescript:
an open source, object-oriented, typed super set of Javascript, created by Microsoft
- It contain all functionality of Javascript
- With additions of classes, interfaces, inheritance, modules, and more
- It is portable across browsers and devices
- It supports strong/static typing

Typescript is not directly runnable by the browser, you must transpile it into javascript before running it in a browser or node

Install typescript with `npm i -g typescript`

To compile typscript into JS, you use the `tsc` command which will output a javascript file with the same name as the ts file

# Babel:
a tool/library used with Javascript to convert between different versions of Ecmascript versions
- typically used to convery newer versions of Javascript into browser compatible versions of Javascript

# Variable Data Types

Like Javascript you still declare variables with let, var, and const, however now you must declare a type:
- ex. `let varname : [type] = value`

There are 11 datatypes in Typescript:
- Boolean: true or false
- Number: integer or decimal
- String: text inclosed by single or double quotes
- Undefined: same as JS
- Null: same as JS
- Any: acts as a normal JS variable
- Void: used for functions that do not return anything
- Arrays: dynamic sized like JS, store a single datatype
- Tuples: an array that can store a fixed number of objects
- Enum: declare a set of named constants
- Never: represents a type of value that never occur

# Classes and Access Modifiers

In typscript the `class` keyword is used to declare a class, and the `new` keyword is used to create a new instance of a class

You can implement inheritance with typescript using classes using the extends keyword similar to java

Typescript has three access modifers:
- public: the default modifer, can accessed anywhere
- private: can only be accessed inside of the class
- protected: can only be accessed inside of the class and children classes

We can also make properties read only with the readonly modifer

In Typescript, the code we write is globally scoped by default. To restrict this Typescript provides modules and namespaces. All variables, classes, and functions declared in a module are not accessible outside of the module

You create a module using the export keyword, and you can use other modules by using the import keyword

Typescript supports getters and setters to access and set class members, you simply use the set and get keyword to create these mutators. You can use these as properties rather than methods

# Interfaces

Interfaces allow us to create contracts that other classes/objects can implement

You define an interface with the interface keyword, which includes the properties you want the class/object to have

You can indlude optional properties with the ?

The typscript compiler does not convert the interface, it is only used for type checking

# OOP Concepts in Typescript

Inheritance: achieved through implementing interfaces, and extending classes, since TS is a superset of Javascript, it can also still be done through proto

Abstraction: achieved through interfaces and abstract classes

Encapsulation: achieved through access modifers provided typescript

Polymorphism: achieved through overriding methods of child classes

# Decorators
A decorator is a special kind of declaration attached to a class, method, accessor, property, or parameter. They look like annotations in Java

In typescript we have to enable experimental support for decorators in tsconfig.ts file

## Types

Class is declared before a class delclaration and is apllied to the constructor of the class, and is used to observe, modify, or replace a class definition

Method is declared beforea method declaration and is applied to the Property Descriptor for the method, they are used to observe, modify, or replace a method definition

Property are used to listen to state changes on a class

Parameter is declared before a parameter declaration and is applied to the function for a class construstor or method declaration

Accessor is applied to the property descriptor for the accessor