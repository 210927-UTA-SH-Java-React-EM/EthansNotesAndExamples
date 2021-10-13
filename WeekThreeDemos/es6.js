//Spread Operator
function sum(x,y,z){
    return x + y + z;
}

const numbers = [1,2,3];

//Break the array apart into its separate vars
console.log(sum(...numbers));

//Use the spread operator to combine arrays
let numberStore = [1,2,3];
let newNum = 4;
numberStore = [...numberStore, newNum];
console.log(numberStore);

//Rest Operator is similar to varargs in java
function sumRest(...args){
    let sum = 0;
    for(a of args){
        sum+=a;
    }
    return sum;
}

console.log(sumRest(1,2,3,4,5,6,7,8,9,10,11));

//Array Destructuring
const detArr = ['one', 'two', 'three'];

//We will store the values from the above arr into
//the values in the brackets below
const [red, yellow, green] = detArr;

console.log(red);
console.log(yellow);
console.log(green);

//Object Destructuring
const user = {
    id: 1,
    isVerified: true
};

const {id, isVerified} = user;

console.log(id);
console.log(isVerified);

let age =10;

//Enhanced Object Literals
const enhancedUser = {
    id,
    isVerified,
    age
}

console.log(enhancedUser);

let dynamicKey = 'fruit';
let coolFunc = () => {
    console.log('It is easy to set functions in objects');
};

coolObj = {
    [dynamicKey]:'apple',
    //coolFunciton: coolFunc
    coolFunc
}

console.log(coolObj);

coolObj.coolFunc();

//Errors can be caught just like in Java with try/catch
try{
    let x = y;
} catch(error){
    console.log('Error name:', error.name);
    console.log('Error message:', error.message);
}

//Using the throw keyword to throw an Error
try{
    throw new Error("This is a message that we can throw with an error");
} catch(e){
    console.log(e.name);
    console.log(e.message);
}

// Create a custom Error with a function
function FunctionError(message){
    this.name = "Function Error";
    this.message = message;
}

FunctionError.prototype = new Error;

try{
    throw new FunctionError('Cool message');
} catch(e){
    console.log(e.name);
    console.log(e.message);
}

//Create a custom error with a class
class ClassError extends Error{
    constructor(message){
        super(message);
        this.name = 'Class Error';
    }
}

try{
    throw new ClassError('Cool message 2');
} catch(e){
    console.log(e.name);
    console.log(e.message);
}