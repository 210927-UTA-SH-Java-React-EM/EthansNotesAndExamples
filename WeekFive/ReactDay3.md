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