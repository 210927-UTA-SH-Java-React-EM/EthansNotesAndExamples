# Jackson Library

The Jackson API is used to convert Java Object into JSON format to send in an HTTP response, and to convert http request bodies to Java objects

Use the ObjectMapper.writeValue() method to convert a Java Object to JSON

Use ObjectMapper.readValue() methos to convert JSON objects to Java objects

# Request Dispatcher

The request dispatcher interface defines an object that passes along the clients request to other resources on the server

There are two possibilites with the Request Dispatcher

- forward(req, res): passes a request from one servlet to another resource on the server. The contents of the request and response are preserved and forwarded to the next resource which will process the data, and return it to the client
    - The client will not know it was forwarded because the url does not change

- include(req, res): does not entirely transfer control over the request and response object to the next resource. Instead this method includes the content of the orginal resource in the response returned to the client

# Redirecting with the Response Object

The .sendRedirect(url) method on the HttpServletResponse object, allows you to redirect the client to a resource outside of the server

Opposed to the forward method on the Request Dispatcher which directs the client to a different resource inside of the server

