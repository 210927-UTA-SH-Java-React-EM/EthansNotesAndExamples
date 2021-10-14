//Symbol Example
let obj = {
    [Symbol]: 'encapsulated'
};

console.log(obj);

let symArr = Object.getOwnPropertySymbols(obj);

console.log(symArr);

//obj[symArr[0]] = 'accessed';

//console.log(obj);

//Iterator it just like a Java iterator, it allows you to iterate through an array or object
let a = [1,2,3];
let iter = a[Symbol.iterator]();
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());

//We can create our own iterator by simply defining a sequence and defining the method next()
let fib = function(num){
    if(num === 0 || num === 1){
        return 1;
    }
    return fib(num-1) + fib(num-2);
}

let fibIter = {
    nextIndex: 0,
    next() {
        let result = { value: fib(this.nextIndex), done:false}
        this.nextIndex++;
        return result;
    }
}

//Now we can iterate over those values by calling next()
let result = fibIter.next();
while(result.value < 50){
    console.log(result.value);
    result = fibIter.next();
}

//Create a generator
function* makeFibGenerator(){
    for(let i =0; i<10; i++){
        yield fib(i);
    }
    return;
}
fibIter = makeFibGenerator();
result = fibIter.next();
while(result.value < 50){
    console.log(result.value);
    result = fibIter.next();
}

//To do the same functionality we can just use the iterable object
const fibIterable = {
    *[Symbol.iterator](){
        for(let i = 0; i<9; i++){
            yield fib(i);
        }
        return;
    }
}

for(let value of fibIterable){
    console.log(value);
}