# Dom Structure

## Document Object Model (DOM):
Tree like structure representing the HTML document known as the DOM tree
- Allows javascript to access and manipulate elements and styles on a webpage

![dom](dom_structure.png)

The root of the DOM tree is our HTML tag, otherwise known as the document object
- Every other element is a node that can be accessed via Javascript

To gain acess to the DOM you simple use the `document` object in Javascript, it gives you access to methods to select elements, traverse and manipulate the HTML Page

# Selecting Elements

There are several ways to select an element in the DOM tree:
- `document.getElementById("idname")`: select a single element based off of its id attribute
- `document.getElementsByClassName("classname")`: select a group of elements with the same class attribute
- `document.getElementsByTagName("tag")`: select all elements with that specified tag
- `document.querySelector("selector")` and `document.querySelectorAll("selector")`: select an element/s with a specified CSS selector

# Traversing the DOM

The document object provides us ways to move through the tree with different properties gaining access to pretty much any object in the tree

To gain access to the top most nodes you can use:
- `document.documentElement` to access the html element
- `document.head` to access head tag
- `document.body` to access body tag

To gain access to the parent nodes of the currently selected element
- `element.parentNode`
- `element.parentElement`

To gain access to children nodes of an element:
- `element.childNodes`
- `element.firstChild`
- `element.lastChild`

To gain access to sibling nodes of an element:
- `element.previousElementSibling`
- `element.nextElementSibling`

# DOM Manipulation

On top of access, and traversing through the tree, you are also able to change/manipulate elements in the dom three with JS

- `document.createElement()` you can create an element and insert into the dom tree
- `element.replaceChild()` remove an element from the DOM and replace it with another
- `element.removeChild()` to completely remove and element
- `element.insertBefore()` to insert an element before the selected one
- `element.innerText` and `element.textContent` to change, set, or get the text in an element
- `element.innerHTLM` to set the HTML of an element
- `element.cloneNode()` used to clone an element

There are also many other useful methods and properties that you can leverage on the element objects to manipulate the page in JS

You can use these methods to manage attributes of html elements:
- `element.getAttribute("attname")`
- `element.setAttribute("attname")`
- `element.removeAttribute("attname")`
- `element.hasAttribute("attname")`

# Events and Listeners

Events occur when a user interacts with a webpage, or when the browser triggers one

You can configure your webpage to handle these events with Javascript using event handlers, events you can handle include:

- onclick: this is a click event occurs when a user clicks the element on the webpage

- ondblclick: this is a click event occurs when a user double clicks on element on the webpage

- onload: this is a load event occurs when the browser is finished loading the page

- onunload: this is a load event occurs when a user closed the document

- onresize: this is a load event occurs when the browser window is minimized or maximized

- onmouseover: this is a mouse event occurs when a user mouses over an element

- onmouseout: this is a mouse even occurs when a user moves the mouse off of an element

- onkeydown, onkeyup, are keyboard events occur when a user presses or releases a key

- onfocus: this a form input event occurs when the user gives focus to an element on the webpage

- onblur is the opposite of on focus

- onchange: this is a form event that occurs when a user changes the input in a form

- onsubmit: this is a form event that occurs when a user submits a form

There are three ways you can register an event handler:

1. Inline, where you set the on... attribute of the html element to a predefined function in your js code
2. You can set the event property of the html element to a predefined JS function
3. You can use the `element.addEventListener(event, function, useCapture)`

# The Event Object

In Javascript events are represented by an Event Object

Event Objects have the following properties and methods:
- bubbles: a boolean value which indicates the propagation method, it is true by default
- currentTarget: a reference to the DOM element whose event listener triggered the specific event
    - This is different from the event that initally triggered the event as a single event can trigger multple event listeners through propagation
- preventDefault(): cancel the event/prevents the default action of the event
- stopPropagation(): prevents the event from propagating further
- target: a reference to the DOM element that triggered the event
- timeStamp: the time of the event in miliseconds
- type: the type of the event

## Types of Events

There are several subclasses of the Event Object, which all include their own properties as well as the properties of the event object
- A complete list of event objects can be found here: https://www.w3schools.com/jsref/obj_events.asp

## MouseEvent

This is an event that is generated when the user interacts with elements on the page with a mouse

Events like click, onmouseenter, onmouseleave, and so create mouse event objects

The MouseEvent object has many properties that hold information about the state of the machine when the event occured:

- Coordinates of the mouse relative to the window: clientX and clientY
- Coordinates of the mouse relative to the last event: movementX, movementY
- Coordniates of the mouse relative to the target: offsetX, offsetY
- Coordinates of the mouse relative to the screen: screenX, screenY
- Whether alt, ctrl, or shift were held when clicking: altKey, ctrlKey, and shiftKey
- Which mouse button was hit: button, buttons, which

## KeyboardEvent

This is an event that is generated when the user interacts with elements on the page with their keyboard

You would typically use this to add funcionality to webforms

Events onkeydown, onkeypress, and onkeyup create KeyboardEvent objects

This object has the following properties:
- Whether alt, ctrl, or shift were hit during the event: altKey, ctrlKey, shiftKey
- Which key was hit: key, keycode, and which
- Whether the key is being held down: repeat

# Bubbling/Capturing

Javascript has something called event propagation, which essentially how the event flows through the components on the page

There are two ways in which an event can propagate, the first is called bubbling, the second is called capturing

## Event Bubbling

Bubbling is the default event propagating for event listeners
- Follow a bottom up approach
- The event starts at the target element, then "bubbles" its way up the tree

Essentially when an event happens, it first goes to any handlers on that element, then that elements parents, then grandparents, and so on until it reaches the top of the html document

Bubbling works for all handlers, regardless of how they are registered

## Event Capturing

Event capturing is the opposite of bubbling, instead of going from the target element to the top of the tree, it will start at the top and work its way down to the target element
- Following a top down approach

Capturing only works with event handlers that are registered with .addEventListener() with an added third argument that is set to true

# Hands on
1. Create an HTML Page with a form
2. Have the user input some information about themselves
3. On Submit, take in the users information, and display it on the page
4. If there is already some user info on the page, the new info should be rendered below the orginal

# Symbol:
a primitive datatype introduced in ES6, typically used to obtain unique indentifiers
- Many API's have a symbol that has been defined as a constant to represent a method
    - Such as Symbol.iterator, Symbol.hasInstance, Symbol.toPrimitive
- To obtain a Symbol you call `Symbol()`

Using symbols, makes it harder to modify a given using the symbol, to do so you may need to use the Object.getOwnPropertySymbols() method to obtain an array of all symbols on the object

# Iterators, Iterables, and Generators

## Iterator:
an object that allows you to traverse values associated within a defined sequence
- Iterators have a `next()` that returns two values, the next value, and done which is true or false
- You can retrieve an iterator from an array with the method called `iterator()`
- If the iterator is finished, every subsequent call to next will return next = undefined, done = true

## Generators:
a special kind of iterator that returns a new value everytime `next()` is called until it reaches the `yield` keyword
- create an generator with the `*function` syntax

## Iterable:
an object that implements the `@@iterator` method (such as any array) is considered to be an iterable

This means that they define iteration behavior and can be used in constructs such as a `for of loop` We mape use the yield keyword like we did in our generator function, but we define `@@iterator`

# Asynchronous Javascript:
program does not need to wait for a specific task that takes a long time

It simply start executing the function, then moves on to the next function while it finishes
- You can send a request/start a lengthy function, and forget about it
- Then when you receive the reponse/the function is finished you can handle it
- You program does not need to wait for the response in the mean time

This is useful with API calls, and other processes that could hold up or "block" the execution of your programs main thread

## How Asynchronous Javascript Works

Javascript implements a stack where functions calls are stored
- It uses a single thread to add, and call functions on the stack one at a time, until the stack is empty
- This is how basic synchronous programming works

Javascript also has a built in queue, and the browser/node runtime environment has extra threads that can used by Javascript, the queue is used by the event loop

## Javascript Event Loop

When an asynchronous call happens, Javascript allows the browser thread/web api to handle the specific call, while moving on in the stack

Once the web api is done processing the function, it will return the callback or the response to the queue, then the next time the call stack is empty, the event loop will return response/callback from the queue

## Basic Animation of the event loop
![Event Loop](gif14.1.gif)

## Basic Steps of the Event Loop in JS

1. Asynchronous call gets added to the stack
2. JS decides to hand it off to the web api where it processes
3. Other functions can be added and executed on the call stack while the web api works
4. Once the web api has a response it gets added to the queue
5. The event loop checks the queue when the call stack is empty to see if something needs to be added to the call stack
6. Our response/callback is added to call stack and process as normal

https://blog.bitsrc.io/understanding-asynchronous-javascript-the-event-loop-74cd408419ff

# AJAX (Asynchronous Javascript and XML):
the process of exchanging data from a web server asynchronously with the help of XML, HTML, CSS, and Javascript
- We use it to load data from a server, and selectively update some part of a webpage without reloading
- Uses the browssers built in XMLHttpRequest object (XHR) to send and receive data from webserveres asynchronously

The AJAX Workflow

1. A client event occurs on the webpage
2. Javascript creates the XMLHttpRequest
3. The XMLHttpRequest Object makes an async request to the server
4. The server process the received request
5. The server create a response and sends data back to the browser
6. The browser processes the returned data using Javascript
7. The page content with updated with Javascript

There are 4 steps in creating an AJAX Request
1. Create a XMLHttpRequest Object with `new XMLHttpRequest()`
2. Set the readystatechange callback function
3. Use the `.open(method, url, async)` method of the XHR object is to open the connection to the server
    - method is a string specifying which HTTP method is being used (GET, POST, DELETE...)
4. Use the `.send()` method to send the request to the server to be processed

The server then sends back a response which can be processed, this is returned in the form of:
- responseText: the response as a string
- responseXML: the response as XML
- status: the status code for the response
- statusText: text representation of the status code

Use the XHR's properties readyState and the function onreadystatechange to observe when the response is ready

The readyState has 5 states:
- 0 is not initalizes
- 1 is connection established
- 2 request received by the server
- 3 server is processing the request
- 4 request finished, response ready

You can set the function onreadystatechange to a custom function to handle the reponse when its ready

# JSON (Javascript Object Notation):
data exchange format that is easy to ready by humans and machines
- Stringified Javascript object

JSON useful for:
- Transmitting data between a server and web application
- Transmitting serialized structured data
- Performing async data calls without needing to refresh the page
- Restful API's

# Working with JSON in AJAX

The XHR object can only send text data, however we can send JSON by serializing it with JSON.stringify()
- JSON.stringify() will convert a JSON object to a string

To get JSON from a response body, we want to use JSON.parse() which will convert the serialized text data to a JSON object

# Promises

Javascript uses promises for async opperations, they are placeholders for a future value. Many async functions return implicitly

Promises in Javascript are objects, and you create them using the new keyword

Promises take a callback function called the executor, this automatically runs the when the object is created
- The executor also takes two callbacks, resolve and reject
    - `resolve(value)` return the result of the job once it finishes sucessfully
    - `reject(error)` is called when there is an error with processing the job

Promises have a property called status which gives us information about the state of the object. The promise can be in one of three states
- pending
- fulfilled
- rejected

The promise objects connects the executor and any consuming functions which will receieve the result or the error from the promise

You would use `.then()` `.catch()` and `.finally()` methods on the promise object to consume (chain) the results or errors of the promise object