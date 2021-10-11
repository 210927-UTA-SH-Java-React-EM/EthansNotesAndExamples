# HTML:
Hypertext Markup Language
- Hypertext Refers to the ability to link pages to one another
- Markup refers to the fact that it is NOT a programming langauage, rather it describes how a webpage will look
- It is the standard for displaying webpages on the internet

HTML uses what are called elements and attributes to create the structure and content of the webpage

# HTML Elements, Tags, and Attributes

## Elements and Tags:
provide the structure of the HTML document

To create an element you use a tag:
- Tags are enclosed with angle brackets <>
- Most elements need an opening and closing tag, a closing tag has a back slash </>, this indicates the end of the element
- Some tags are self closing, they do not require a closing tag `<sometag/>`

## Inline vs Block Elements

Block-level elements will render on new lines by default

Inline elements will/can sit next to each other on the same line when rendered

## Common HTML Elements:

-   `<div>`
    -   This is a block level element denoting a division of the page that typically will hold other elements
-   `<p>` (paragraph)
    -   This is a block level element denoting a paragraph
-   `<span>`
    -   This is an inline element that allows you to group other inline elemnts
-   `</br>` (break line)
    -   Self closing block-level element that adds a new line to the page
-   `</img>` (image)
    -   Self closing inline element that allows you to add images to your page
-   `<h1>` through `<h6>` (heading)
    -   Block elements denoting header text, h1 is the largest and h6 is the smallest
-   `<a>` (anchor)
    -   Inline element that is used to create a hyperlink

## HTML Attributes:
Attributes are key/value pairs that give metadata about the tag that is important for the browser to know
- These are specified inside of the opening tag
- Can be thought of as parameters defining the specific

There are global attributes that can be applied to litterally any element in an html page
- class
- id
- hidden
- lang
- style
- title

There are also tag specific attributes:
- `<img>` has src and alt
- `<a>` has href

# HTML Doctype and root tag

## Doctype:
Every HTML document should begin with a special tag known as the DOCTYPE declaration
- This lets the browser know what kind of document and version it should be displaying
- We just use HTML for HTML 5
    - `<!DOCTYPE html>`

## Root tag:
Every HTML document must also have a root tag `<html></html>`
- Everything must go between the opening and closing root tag
    - `<head>` tag goes inside of the root tags to hold information about the webpage
    - `<body>` tag goes inside of the root tags to hold the structure/content of the page

# HTML Tables:
Used in HTML to nicely structure and display data:
- `<table>` create a table
- `<thead>` define a header row
- `<tr>` create a new row in the table
- `<th>` create header column
- `<tbody>` specify the main body of the table
- `<td>` create normal table column
- `<tfoot>` to create a footer

Using these different table elements and css, old websites used to exclusively use tables for their layouts

# HTML Lists
Used to display list of items
- `<ol>` creates an ordered list (numbere starting at 1)
- `<ul>` creates an unodered list (bullet points)
- `<li>` create a list item inside of the defined list
- You are allowed to next lists inside of one another

# HTML Hands On #1: Using the different elements in HTML we just spoke about, create a webpage with everyone on your teams:
1. Name
2. Background (Schooling or whatnot)
3. Something interesting/fun
4. Optional, a nice profile pic, we will style these later