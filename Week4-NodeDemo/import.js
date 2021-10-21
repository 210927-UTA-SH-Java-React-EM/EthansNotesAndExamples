//To import we have to require the module
let greeting = require('./helloNode');

let oss = require('os');

console.log(greeting('Bob'));

//Global objects, the global object is like the window object of the browser, and has methods such as 
//setTimeout

setTimeout(()=> console.log('Hello after a second'), 1000);

//We other properties on the global object, such as process, which allows us to see system variables
console.log(process.env);

//os module of node lets us see general pc information
console.log(oss.totalmem());