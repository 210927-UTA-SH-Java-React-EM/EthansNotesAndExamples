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

# HTML 5
The most recent version of HTML Markup Language, it introduced many new changes including:
- The DOCTYPE declaration
- Character encoding metadata in the head of our document
- The ability to embed audio and video files
- The ability to run JS in the background
- New semantic elements

## Semantic elements:
give tags descriptions rather than only being for functionality

Tags such as `<div>` `<p>` and `<span>` are non-semantic

Tags such as `<table>` are semantic tags we already had previous to HTML 5

HTML 5 introduced these semantic tags:

-   `<section>`
-   `<article>`
-   `<header>`
-   `<footer>`
-   `<nav>`
-   `<aside>`
-   `<figure>`
-   `<figcaption>`
-   `<details>`
-   `<mark>`
-   `<summary>`
-   `<time>`

## HTML 5 Audio and Video Tags

HTML also implemented the abililty for you to embed audio and video onto your webpages

## audio tag:
Use the `<audio>` tag to embed audio directly into a page
- `controls`attribute used in the `<audio>` tag enables the control bar
- `<source>` tag is used to specify the audio source and type with the give attributes:
    - `src` specifies the source
    - `type` specifices the audio file type

Supported audio types:

| File Format | Media Type |
| ----------- | ---------- |
| MP3         | audio/mpeg |
| OGG         | audio/ogg  |
| WAV         | audio/wav  |

## video tag:
Use the `<video>` tag to embed video directly into a page
- `width` and `height` attributes allow you to set the size of the video
- `controls` is also available like with audio
- the same `<source>` tag and attributes are used for the `<video>` tag

Supported Video Types

|Format|  MIME-type|
|-----|----|
|MP4  |video/mp4|
|WebM |video/webm|
|Ogg  |video/ogg|

# Form Elements and Its Attributes

Use forms to collect data from users of the website
- Use the `<form>` tag to create a new form

The form tag has the following attributes you can set:
- action: typically the URL of the server where you are sending information
- target: tells the webpage where to load the new page
- method: specify which http method to use when submitting

The `<input>` tags inside of the form can having the following attributes
- name: provides a label for that specific input field
- value: allows you to specify an initial value for the field
- placeholder: allows you to specify a placeholder text for the form field
- required: makes it so the user must fill out this field
- min/max: specify a minimum or maximum value for the field

## Input Elements and Input Types

The input element is used to get information from the user inside of the form tags, there are many types of input elements inlcuding:
- text: one line text input
- password: test field where the input is hidden
- radio: buttons that only allow one selection per group
- check boxes: buttons that allow multiple selections per group
- file select: allow users to upload files
- textarea: a multiline multicolumn text field
- select: allows for a user to select from a dropdown
- reset and submit: which do exactly as they sound

To submit a form, you can create an input type of submit, this will automatically submit the form, and reload the page

# HTML5 Validation

Before sending form data we want to perform what is called client side form validation

There are two ways of accomplishing this:
- Javascript and bult-in form validation

HTML5 introduced several ways to validate form data:
- required attribute: forces the user to fill out that specified field
- minlength and maxlength: indicate the minimum or maximum length text can be
- min and max: indicate the min and max amount a numeric field can be
- type: defines the type the data should be
- pattern: defines a pattern (regular expression) that entered data should follow

When data is verified and it satisifies the constraints, they are considered valid, and will be given the CSS psuedo class :valid which can be used to modify the look of the page if the users input is valid

The opposite is also true, id validation doesn't go through, the input will be given the CSS psudeo class of :invalid which can be used to modify the look of the page if the users input is invalid

# CSS (Cascading Style Sheets):
sets of key/value pairs, that create rules that define how elements on webpage should look

A CSS rule is composed of selectors and declarations
- Selector is an HTML element, or group of HTML elements
- Declarations is comprised of properties and values surrounded by curly braces

# Inline, Internal, External Style Sheets
There are three ways in which you can use CSS:

1. Inline CSS, this is CSS applied directly to the elements in the HTML document
2. Internal, Embedded  CSS, this is CSS written inside of the `<style>` tag in the head of the document
3. External CSS, is a completely indepenent css file that you import in your html document
    - use the `<link rel="stylesheet" href="style.css">` to link css file

# CSS Box Model:
The box model is used to determine how the webpage is rendered by the browser
- Every element in the page is a series of boxes, and CSS allows us to modify of them

## The four parts of the box model:
- Margin: is the outer most retangle
- Border: is the area between the margin and the padding
- Padding: is the space around the content and border
- Content: is the element itself

![Box Model](https://upload.wikimedia.org/wikipedia/commons/e/ed/Box-model.svg)

# CSS Properties

There are numerous properties that we can adjust to style different elements on our webpage

-   border: allows you to change, the shape, size, color, and style of the border
-   padding: allows you you change the height and width of the padding around the element
-   margin: allows you to change the height and width of the margin outside of the border
-   display: allows you to control the display behavior of an element
-   position: allows you move the elements where you want on the page
-   color: allows you to change the color of the element itself
-   text-align: allows you to align text content inside of the element

# CSS Selectors:
used to select specific elements for groups of elements to be styled on the webpage

There are several ways to select elements in CSS including:

-   Element selectors: selects by the elements tag (p, h1)
-   Id selector: selects an element by the its id attribute (#id)
-   Class selector: will select a group of elements by the class attribute (.classname)
-   Universal selector: will select all elements on a page (\*)
-   Attribute selector: will select all elements with the specified attribute (\[atribute])
-   Grouping selector: selects multiple elements by their tag, separated by commas
-   Child selector: will select direct children of a specific element (div > p)
-   Descendent selector: will select all of the specified elements nested inside of the parent (div p)
-   General sibling selector: will select sibling elements on the same hierarchy level (div ~ p)
-   Adjacent sibling selector: will select the first sibling of the specified element (div + p)
-   Pseudo class selector: used to specify the state of an element (:visited)
-   Pseudo element selector: used to style parts not specified by the DOM tree (::first-letter)

## Specificity in CSS

In CSS you are allowed to have multiple rules for a single element, in order for the browser to know which rules to apply, there must be a style hierarchy which is followed, known as Specificity

This only applies when a single element is targeted by multiple CSS declarations, the order of specificity is as follows

1. Inline CSS
2. ID selector
3. Class Attribute and Pseudo-class selectors
4. Element and Psuedo-element selectors