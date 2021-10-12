console.log("Hello JS");

//This is a single line comment

/*
    This is a multi line comment
*/

//Javascript is loosely typed so you can change the variable to any type you want
//A number
var a = 100;

//Null
a = null;

//undefined
a = undefined;

//A string
a = 'A string';

console.log(a);

//You can create string with either single quotes or double quotes, you can even include quotes inside of the string

//Single quote example
var name = 'Rick';

//Double quote example
var lName = "Sanchez";

//Single quote inside of a string
var c = "Let's go on an adventure";

//Double quote inside of string
var d = 'He said "Hello" and left';

//You are also able to escape quotes
var e = 'We\'ll never give up';

console.log(e);

//Number example
//Integers
var n1 = 21;

//Floating point
var n2 = 15.5;

//exponential notation
var n3 = 1.5-4;
var n4 = 1.5e4;

//What happens when we do this?
var n5 = -6/0;
console.log(n5);

//There is also a number called bigInt which stores numbers larger than 2^53
var bigInt = 12345678901234567890n; //The n at the end denotes a big int

//Booleans can be true or false
var t = true;
var f = false;

//Objects in JS
var obj = {
    name: 'Tiny Rick',
    age: 16
}

//Access the values inside of the object in two ways
console.log(obj.name);
console.log(obj['age']);

//You can also create objects using the new keyword
var obj2 = new Object();

//Then assign the values using dot notation or the square brackets
obj2.name = 'Morty';
obj2['age'] = 15;
console.log(obj2);

//Arrays
//You can create an array by predefining its indexes
var arr1 = ['Bob', 'Shirley', 'Tom'];
//You can also use the new keyword
var arr2 = new Array(1,2,3,4,5);
//You can also mix and match the data types
var arr3 = ['bob', false, 23, {name: 'bob'}];
console.log(arr3);

//You can find the amount of items in the array with the length property
console.log(arr3.length);

//You can access indexes with the bracket notation
console.log(arr3[0]);

//You can add elements to te array at any given index
//We can also change the value at a given index
arr3[4] = 'New element';
arr3[1] = true;
console.log(arr3);

//You can also use the .push() method provided by the array object to add elements at the end of the array
arr3.push(53);
console.log(arr3);

//shift() method will remove the first element of the array
arr3.shift();
console.log(arr3);

var arr4 = ['cat', 'dog', 'deer', 'bird', 'rabbit'];
arr4.sort();
console.log(arr4);

//indexOf and lastIndexOf will search for an item in the array
console.log(arr4.indexOf('dog'));
console.log(arr4.lastIndexOf('bird'));

if('0'){
    console.log('truthy');
}else{
    console.log('Ethan retires');
}