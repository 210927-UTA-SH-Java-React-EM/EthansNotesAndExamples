//Lets first show how to create a closure
const Book = function (t,a){
    let title = t;
    let author = a;

    return {
        summary: () => {
            console.log(`${title} written by ${author}.`);
        }
    };
};

const book1 = new Book('The Hobbit', 'JayAreAre Tolkien');
book1.summary();

book1.a = 'Not the hobbit';
book1.summary();

//Lets look at the preclass way to inherit
let animal = {
    eats: true,
    walk: () => {
        alert('Animal Walk!');
    }
};

//Create the child object
let rabbit = {
    jumps: true,
    __proto__: animal
}

console.log(rabbit.eats);
console.log(rabbit.jumps);
rabbit.walk();

//Using a class to inherit from
class Animal {
    constructor(name){
        this.name = name;
    }

    static breathe(){
        console.log('breaths');
    }

    speak(){
        console.log(`Hello my name is ${this.name}`);
    }
}

//Inherit the class
class Cat extends Animal {
    constructor(name, color){
        super(name);
        this.color = color;
    }

    //We can even override some functionality
    speak(){
        console.log('Meow');
    }
}

let a2 = new Animal('Doug');
console.log(a2);
a2.speak();
Animal.breathe();
console.log(a2 instanceof Animal);
console.log(a2 instanceof Cat);
let cat = new Cat('Mister Meow Meow', 'Gray');
console.log(cat);
cat.speak();
Cat.breathe();
console.log(cat instanceof Animal);
console.log(cat instanceof Cat);

//Finally if you wanted to export the class to be used, you can use the export keyword
//export {Cat};