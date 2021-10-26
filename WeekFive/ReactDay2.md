# Class Components Overview

React components start with an uppercase, and follow PascalCase nameing convention

Class based are simply Javascript classes that extend React.Component they class include:
- render(): return JSX that is what you component is going to look like
- constructor(): gets called when the component is instantiated, where you want initialize any state for your component
    - conststructor should include `super()` keyword as the first line

# Data binding

In React we can inject a variable value into a components JSX with curly braces {}, this is considered data binding

