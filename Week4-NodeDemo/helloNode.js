//We can use node to run our js outside of the browser, letting us develop servers using js
//We can also call the node command in out window to execute code in REPL session
//REPL: Read Eval Print Loop
//I mentioned last week that ES6 gave us modules
//Modules are one of the great feature about node
// Modules are essentially a unit of js code that is meant to be reused by exporting then importing

console.log("Hello Node");

function greeting(name){
    return `Hello my name is ${name}`;
}

module.exports = greeting;