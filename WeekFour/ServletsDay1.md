# Client Server Architecture

A client-server architecture is a networking model in which the server provides services to clients to perform user based tasks

Server: is a server software designed to process requests and deliver responses to another computer over the internet

Client: is a program that runs on a local machine requesting service from a server

![client server](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Client-server-model.svg/1200px-Client-server-model.svg.png)

A client and server establishes a connection over the internect using a set of rules called a protocol

There are different protocols for different purposes, but we will mainly focus on HTTP

- Clients send a HTTP request to the server in the form of XML or JSON
- Servers send HTTP responses to the client

Types of Client-Server Architectures:

- 2-tier: simple client to server interface
- 3-tier: client connects to a middleware, the middleware connects to the server
- n-tier: multiple layers between the client and the server

# HTTP
Hypertext Transfer Protocol is a client server protocol

It allows us to send information between clients and servers via HTTP messages using the TCP protocol

HTTP Requests are the messages sent from the client to the server

They are composed of:

- Verb: the HTTP method being executed
- URI: the endpoint of the resource
- HTTP Version
- Request Header: contains metadata about the request
- Request Body: the data that we are sending

![http-request](http-request-image.png)

HTTP Responses are the message that are sent back to client from the server

They are composed of:

- Response/Status Code: information about the success or failure of the request
- HTTP Version
- Response Headers: contains metadata about the response
- Response Body: any data being sent to the client from the server

![http-response](http-response-image.png)

# HTTP Verbs

Two important characteristics of HTTP methods are if they are:

## Idempotent
identical requests can be made once or serveral times in a row and return the same result every time

## Safe
the request does not alter the sate of the server

The verbs of HTTP include

## GET
- Used to retreive data
- No request Body
- sage
- idempotent
- cacheable
- allowed in html forms

## HEAD

- Essentially the same as GET, but the servers response should not include a body
- Used to retrieve data
- No request body
- safe
- idempotent
- cacheable
- NOT allowed in html forms
- NO reponse body

## POST
- sends data to the server
- will often be used to create of update data
- it is not idempotent or safe
- technically, but really cacheable
- allowed in html forms
- request and response body

## PUT
- used to update a target resource such that it replaces the current representation with the one included in the PUT request
- is idempotent
- not safe
- not cacheable
- not allowed in html forms
- response does not have a body
- request does have a body

## DELETE
- used to delete a resource
- might have a request and or response body
- not safe
- not cacheable
- not allowed in html forms
- is idempotent

## CONNECT

-   starts a "tunnel"-- two-way communication with the resource
-   No request body
-   Recieves a response body
-   **NOT** safe, idempotent, cacheable, or supported by html forms

## OPTIONS

-   Get the options for communication with a particular resource
-   safe, idempotent
-   request has no body
-   response has a body
-   Not cacheable or available in html forms

## TRACE

-   message loop-back test between client and resource
-   useful for debugging
-   no request body or response body
-   not safe, cacheable, or allowed in html forms
-   idempotent

## PATCH

-   similar to update
-   changes partial aspects of a resource
-   request and response have a body
-   **NOT** safe, idempotent, allowed in html forms, or cacheable

## HTTP Status Codes

Status Code gives us information about our request

Informational Responses: 100-199

Successful Responses: 200-299
- 200 OK
- 201 Created
- 202 Accepted

Redirects: 300-399
- 300 Multiple Choices
- 301 Moved Permanently
- 302 Found

Client Errors: 400-499
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found

Server Errors: 500-519
- 500 Internal Server Error
- 503 Service Unvailable

# Servlets

A servlet is a Java Class that takes incoming requests, processes them, and generates a response to send back to the user

How servlets works:

![servlet](./Servlet.jpg)

1. The client sends a request to the application server (web server)
2. The server passes the request to the appropriate servlet
3. The servlet processes the request, and generates a response
4. The response gets sent back through the application server to the client

# Servlet API
The servlet API provides the interfaces and classes that are needed to build servlets. You can find these classes and interfaces in two packages:
- java.servlet package - used by the servlet or web containers
- javax.servlet.http package - used for handling http requests

## Servlet Inheritance Hierarchy

The root is the Servlet Interface -> GenericServlet implements Servlet, ServletConfig, and Serializable interfaces

GenricServlet is an abstract class, which is meant to be extended to implenent specific types of servlets

HttpServlet extends the GenericServlet class and implements Serializable, this provides the ability to process HTTP requests with doGet(), doPut()...

You can extend HttpServlet to override the default implementation for doGet, doPost, etc to provide the nedded functionality for your servlets

# Web/Application Server and the Servlet Container

A webserver is used to handle HTTP requests, where an Application Server is used to handle any type of requests

Application servers pass incoming requests to the application running, most application servers double as a web server

We wil be using Tomcat as our application server

The servlet container is a component of some application servers that interact with Java servlets
- They are responsible for managing the life cycle of servlets
- Mapping a URL to a specific servlet
- Ensuring the URL requester has correct access

The built in servlet container with Tomcat is called Catalina

# Life Cycle of a Servlet

There are three main methods of the servlets life cycle:
- init()
- service()
- destroy()

The steps of the servlet life cycle:
1. Loading of the Servlet
    - When the application server starts up, the servlet container deploys and loads all of the servlet classes
2. Create an instance of Servlet
    - Once the servlet classes are loaded, the servlet container creates a single instance for each servlet class
3. Invoke init() once
    - Once the servlet classes are instantiated, the init() method is invoked for each instantiated servlet
4. Invoke the service() method for each client request
    - Service determines what type of request was sent from the client, and calls the corresponding method to process it
5. Invoke destroy() method once
    - This will be called at the end of the servlets life

# Deployment Descriptor

Java web applications use a deployment descriptor file to define URL's that map to servlets, and to determine which URL's required authentication

The descriptor file specifies the classes, resources, and configurations and how the web service uses them to serve HTTP requests

The descriptor is stored in a file called web.xml, stored in the WEB-INF directory of the project

# Servlet Declarations and Mapping

To map the servlet you declare the servlet with the `<servlet>` tag, using the `<servlet-name>` and `<servlet-class>` tags inside of

To Map URL's to a servlet class you use the `<servlet-mapping>` tag, using the `<servlet-name>` and `<url-pattern>` tags inside

# Response Object

The Servlet API provides HttpServletResponse interface which extends the ServletResponse interface to assist in sending response to the client

This allows you to send respones, with different types of data, including HTML, XML, text and more

Simple set the content type with the .setContentType() method, and use a printWriter to write back to the client