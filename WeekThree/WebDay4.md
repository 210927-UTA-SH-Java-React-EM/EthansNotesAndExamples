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

