# fetch

fetch is a more modern and versatile way of making AJAX requests
The fetch API is provided by the window object, and provides the `.fetch()` method

- `.fetch()` is used to send requests and returns a promise that is retrieved from the response
- Successful requests get resolved, the returned promise will have the response body
- Request that return an error HTTP-Status will be rejected

There are various methods you can use to access the response body of a success request:
- `response.text()` read the response and return as text
- `response.json()` parse the response as JSON
- `response.formData()` return the response as FormData object
- `response.blob()` return the response as Blov (binary data with type)
- `response.arrayBuffer()` return the response as an ArrayBuffer (low level representation of binary data)

# async/await
introduced in ES8 to simplify asynchronous functionality

The async keyword denotes that a function will operate asynchronously via the event loop
- Any function with the async keyword will implicitly return a promise object
- Yuo can use any of the consumer function on the return of an async function, however there are nicer ways to handle these promises using await

The await keyword only works inside of async functions
- await tells Javascript to wait for a promise to resolved before moving on
- You can use await when calling any function that returns a promise, but it must be inside of an async function
- It allows you to gather data, or wait for something while also not blocking the main thread

You no longer need to chain consumer functions together, making your code easier to read

# Timing Events
are functions that are attached to the global window object, and allow programmers to automate or run tasks after waiting a specific amount of time

These get handled by the event loop and web threads

## setTimeout()

`window.setTimeout(callbackFunction, milliseconds)` will execute the callback function after waiting for a specific amount of milliseconds

Use the `window.clearTimeout(timeoutVariable)` to stop a timeout before the execution of the callback function

## setInterval()
`window.setInterval(callbackFunction, milliseconds)` continually executes the callback function ever so many milliseconds

Use `window.clearInterval(intervalVariable)` to stop the interval, similar clearTimeout


# Hands On
1. Create an HTML page that has an input field and a button
2. On submission, make a call to the PokeAPI to get the information about the pokemon input in the field
- https://pokeapi.co/api/v2/pokemon/{id or name}/
3. Once you receive the information, display the pokemons name, and an image of the pokemon

More information about the API: https://pokeapi.co/docs/v2#pokemon