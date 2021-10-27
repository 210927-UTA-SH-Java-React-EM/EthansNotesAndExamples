# Event Handling

Event handling in React is similar to HTML, however with JSX you must use camelCase for the event name, and pass tghe event handler as a JS reference rather than a string

## Synthetic Events:
cross browser wrapper around the browsers native event, this is used when an event occurs in React

Used because it is capable of pooling, which means the SyntheticEvent objects are reused to improve performance, however, issues can arise because after the callback is called the properties are nullified

# List and Keys

If you want to render a list of elements in React, it is typically done with the `.map()` function

However, React expects you to provide a unique key for each element that you are mapping through.
- This helps React indentify which items have been changed, added, or removed

The only time you should use an index as a key is when you have no other options

# Hands on Number 1, create a stop watch using event handlers and the setInterval function from javascript

# More Advanced Component Techniques

## Higher Order Components:
functions that take a component and return a new component with added functionality

These can be used to handle cross cutting concerns and allow for more reusablity

You can either create your own higher order components, or there built in ones, like React Router withRouter is a high order function that provides more routing functionality

## Containment:
used when a component doesn't know its children ahead of time, common for use with components that represent generic boxes

You would pass the components through props to the containing component, then you can pass whatever child components to the parent component through said prop

## Specialization
used when a component is a special case of another component

Again you would pass the different components as props, this time they should be separate props unlike above

Then the parent component would choose whether to render the "generic" or "specific/special" child component based off of some logic

# Routing
allows users to have the experience of navigating through different pages while actually staying on the same SPA page

React can swap out views with different URL paths
- React is not actually SPA by default, however, using React Router is the most popular way to make it a SPA with routing

# React Router and React Router DOM

React Router is a declaritive model for navigational components within your application

React Router DOM provides several solutions for creating a router in your application depending on the relationship you want your UO to have with your URL

## BrowserRouter:
uses HTML history API to keep the UI in sync with the URL
- Wrap the BrowserRouter tag around `Route` tags, where each Route represents a renderable component
- The component to be rendered is nested inside of the Route tag
- The `Switch` tag is used to ensure that each component is rendered exclusively per route