//A function that utilizes a simple if statement
function simpleIf(){
    if(5>2){
        console.log('yay');
    } else {
        console.log('boo');
    }
}

simpleIf();

//A function that utilizes a simple if/else if statement
function simpleElseIf(num){
    if(num<0){
        console.log('Num is less than 0');
    } else if(num === 0){
        console.log('Num is 0');
    } else {
        console.log('NUm is greater than 0');
    }
}

simpleElseIf(-1);

var arr = [1,2,3,4,5,6,7];

//A simple for loop
for(i=0; i<arr.length; i++){
    console.log(arr[i]);
}

//A simple while loop
var num = 0;
while(num<10){
    console.log(num);
    num++;
}

//A simple do while loop
do {
    console.log(num);
    num++;
} while (num <= 9);

// Enhanced For Loops
//For of is used for arrays and array like objects
for(num of arr){
    console.log(num + 10);
}

//For in loops are used to access keys of an object
var obj = {name:'bob', age: 23};
for(prop in obj){
    console.log(prop + ":" + obj[prop]);
}

//We can assign functions to variables
function add(num1, num2){
    return num1 + num2;
}

var answer = add(10, 34);
console.log(answer);

//Functions can be assigned directly to variables, anon function
var coolFunction = function(){
    console.log('I am anonymous');
}

coolFunction();

//Callbacks are used everywhere, Array methods find(), filter() map() and reduce() use callbacks to 
// operate on the data

//find returns the first element that satisfies the callback function
var greaterThan = arr.find(function(n){
    return n >2;
});

console.log(greaterThan);

//filter filters objects based on a callback
var greaterThanFilter = arr.filter(function (n) {
    return n > 3;
});

console.log(greaterThanFilter);

//map takes a callback and returns a new array that is the result of calling the function on the index
var squares = arr.map(function(n) {
    return n*n;
});

console.log(squares);

//Default parameters
function defaultParams(a, b=1){
    return a*b;
}

console.log('Making use of the default parameter', defaultParams(2));

console.log('Inputting two parameters', defaultParams(2,3));

//We can create disembodied functions with arrow notation since es6
//A simple arrow function
var simpleArrow = () => console.log('Hello I am an an arrow function');

var paramArrow = (num) => {
    console.log('We were given the number: ' + num);
    console.log('The square of ' + num + 'is' + num*num);
    return num * num;
}

simpleArrow();
paramArrow(3);

//Scopes
//Anything out here is global scope
var sc1 = 'I am global scope';

//Anything inside of a block of code is considered local
function scopes(){
    var sc2 = 'I am function scope';
    if(sc2){
        let sc3 = 'I am block scope';
    }
}

hoistEx();

function hoistEx(){
    console.log('I hoisted myself');
}

//Any variable without let or const will be hoisted out of block scope
function varHoist(){
    if(1>0){
        var hoistMe = 'I got hoisted out of the if block scope';
    }
    console.log(hoistMe);
}

varHoist();