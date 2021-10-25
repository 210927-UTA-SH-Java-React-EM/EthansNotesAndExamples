# Single Page Applications

Single Page Applications (SPA's)  are webapps that render on a single page in the browser

All of our Javascript, HTML, and CSS are loaded in and ready for the browser in one page load

During navigate, the browser never refreshes because you stay on the same page

We will use React to create SPAs

The advantages of SPA's:
- Fast and Responsive
- Caching Capability
- Please user experience across multiple platforms

Disadvantages:

- Doesn't perform well with SEO
- Less secure against Cross-site scripting
- The page may take longer to load initially

# Webpack

Webpack is a powerful static module bundler for Javascript applications that packages all modules in our application into a bundle and serves it to the browser

This means all of our JS files and dependencies would be in a single file, all of HTML files would be in a single file and so on

This helps speed up the loading of our webpage, because instead of loading loads of files being requested the browser loads one

Webpack builds a dependency graph when it processes the application. It starts from a list of modules defined in its config file and recursively builds a dependency graph that includes every module our application needs, then packages all of those modules into a small bundle that can be loaded by the browser

# React Overview

React is a lightweight, Javascript **library** created in 2011 by Facebook, meant to be used in conjunction with other modules for the purpose of creating frontend user interfaces for web applications

## Framework vs Library

Frameworks are an entity that takes your code and executes a lot of abstracted away processes

While the pros for a framework are that they do a lot of work for you, the cons include:
- more features, bloats the size of the framework
- less flexible with how features are used
- must use the entire framework for one feature
- less customizable

React is library, it is only designed to enable users to declaritively describe their user interfaces
- it doesn't benefit from the opionated nature frameworks
- smaller/less bulky because its only made to do one thing
- use other libraries/modules that you NEED to expand the functionality
- instead of a framework doing everyting for you, the developer is reposinsible for connecting each component

## Tradeoffs and Cons of React

React doesn't use HTML templates, you simple write your components in a JS file, this mean you must have a better understanding of javascript

React doesn't follow "traditional" MVC, all data for a component is stored in one file, the components should be separated by concern

React uses JSX instead HTML, and JSX differs slightly from HTML, so you must learn the new syntax

React versioning is updated frequently so version changes and forward compatibility need to be taken into account

Online resources for React could be outdated (stackoverflow posts)

Since React is so flexible there can be a lot of decision fatigue. There are a lot of choices you have to make, which usually falls into these categories: Dev Environment, Class or Functional components, Types, States, Styling

## create-react-app

The easist way to create a new React application is with the `create-react-app` CLI

You can either use:

`npx create-react-app name-of-app` or

Install the create-react-app globall with npm call

`create-react-app name-of-app`

Either use of create-react-app will result in a newly generated React App that comes preconfigured with dependencies such as babel, webpack, jest, and more

# Typescript with React

React provides the flexibility to use either Javascript or Typescript to build components, and the create-react-app tool allows you Typescript out of the box

We will be using typescript to develop our React Applications

You can either create a react app with the typescript template, or install the typescript modules for react

To create a new React Typescript project:

`npx create-react-app name-of-app --template typescript`

Or to convert an existing application first install modules:

`npm i --save typescript @types/node @types/react @types/react-dom @types/jest`

Then create the tsconfig"

`npx tsc --init`

Then finish up by setting any of the config settings that you like

## Type Definitions

Since typescript is known for its strict typing, when you setup React to work with typescript it comes with special types, we will be seeing these when we start creating components

# Component Based Architecture:
a software architecture that focuses on breaking the application into individual functional or logical components

These components comunicate with one another to create a larger application. These components should follow the Single Responsibility Principle

## Single Responsibility Principle
the programming principle that every module/component should have responsibility over a single part of the applications functionality

Componenet based architecture helps ensure component resuablity, and increased reliablity due to the reuse of existing components

React follows Component Based Architecture, and you should design your components to use the Single Responsibility Principle

# React Components
are resuble peices if UI in React, breaking the UI into components helps with the maintainability of your code

Two ways of creating components:
- Traditional class based
- Newer, recommended function based

Function based used to be less useful because they did not have full functionality of class based, however now they are essentially the same funcationlaity and are shorter, and more precise than class based.

There is actually now talk that class based components could be deprecated in the future

React Renders the components in order to display them to the view

## Rendering

Our react components are injected into the root html element to be displayed on the page, in fact we never leave the one html page, we just swap components in the root element of the index.html

## Virtual DOM

React uses a virtual DOM to map the components view to the actual dom object (because we don't actually write html in react)

Rendering the page, and updating the real DOM is costly in performance

So the Virtual DOM is much more lightweight than the actual DOM, which is why React uses it only to update the real DOM when absolutely neccessary.

# JSX/TSX (Javascript XML):
used to create the template for React components. It looks like HTML, but it written inside of javascript. This gets injected into the virtual DOM and diplayed in the browser

JSX uses Babel to compile it to ES5 or ES6 before everything is rendered

JSX unlike HTML is case sensitive, lowercase tags are rendered as HTML elements, uppercase tags are rendered as React Components

It is important to remember to always wrap your entire JSX in a single root tag, this is because of the way React handles reconciling the DOM

# Container and Presentation Components

A design pattern for creating components

The container component contains all the "logic"/"state" of the component

The presentation component is a child of the container component, that simply displays the state of the data

Other names for this design pattern are "Smart and Dumb", "Controller and View", "Data and Display"