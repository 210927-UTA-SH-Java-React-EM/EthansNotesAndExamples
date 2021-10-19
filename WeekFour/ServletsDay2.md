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

# Hands With Servlets
1. Create a Register Servlet
    - The app should display the Register page when a get request to /register
2. Create a Register html page with a form to register a user with the user model
3. After creating a user, you should be redirected to the login page

# Servlet Config and Servlet Context

Serlvet Config is an object created by the Servlet Container, used to pass initial parameters or configuration information to a particular servlet

- Setup inside of the `<servlet>` tags in the web.xml
- User the `<init-param>` and nest `<param-name>` and `<param-value>` inside of it
- You can programatically get these properties with .getServletConfig() method of the HttpServlet class

ServletContext is the object created by the Servlet Container to share inital parameters or configuration will all servlets and other components

- Use the `<context-param>` tag outside of the `<servlets>` tag
- Inside of the context param tag you use `<param-name>` and `<param-value>`
- You can programatically get these properties with the .getServletContext() method of the HttpServlet class

# Eager Loading and Lazy Loading Servlets

Eager Loading the servlet container loads and initializes the servlets when the server starts running

Lazy loading the servlet container loads and initilizes the servlets when the first request arrives

To enable Eager loading include the `<load-on-startup>` tag in the servlet mapping 

The number inside of the load on startup tells the servlet container what sequence the servlets should be loaded

# Filters:
are used to intercept a request and conduct pre or post processing on the request

Configure them in the deployment descriptor, and use the FilterAPI found in javax.servlet package to define what the filter does

## Filter API

Has three interfaces:
1. Filter: creates a filter by implementing the interface, it provides the life cycles methods for a filter
2. FilterConfig: an object that contains the filters initilization parameters
3. FilterChain: an object used to call the next filter in the resource chain

## Filter Life Cycle Methods:

init(FilterConfig config): called once and used to initialize the filter

doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain): this method does the filter logic, filterchain allows you to move onto the next filter

destroy(): called once when the filter is taken out of service

In the Java Servlet API 4.0 we only need to override the doFilter() because init() and desrtoy() are implemented as default methods

# Exceptions and Error Handling

The servlet API allows us to handle exceptions and erros caused during execution of a servlet, and still send a useful response to the user

You just need to include the `<error-page>` element in your web.xml, this is used to specify the invocation of servlets in response to certain exceptions or http status codes. You can use the following inside of `<error-page>`
- `<error-code>`: used to specify the status code
- `<exception-type>`: used to specify an exception
- `<location>`: used to specify the location to a resource which is displayed upon an error

Before the servlet container invokes the servlet to handle the exception, it sets some attributes in the request to get useful information about the exception:
- javax.servlet.error.status_code
- javax.servlet.error.servlet_name
- javax.servlet.error.exception
- javax.servlet.error.request_uri
- javax.servlet.error.exception_type
- javax.servlet.error.message

