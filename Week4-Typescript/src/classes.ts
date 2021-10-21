//We create classes using the class keyword and an instance of that class using the new keyword
//TS supports getters and setters to access and set class memebers, the getter and setter are created by
//using the get and set keywords
class Animal {
    //fields
    readonly name: string;
    private species: string;
    constructor(name: string, species:string){
        this.name = name;
        this. species = species;
    }

    //create a getter for species
    get getSpecies(): string{
        return this.species;
    }

    //create a setter for species
    set setSpecies(sp: string){
        this.species = sp;
    }

    //methods
    move(feet: number):void{
        console.log(`The ${this.species}, ${this.name} moved a total of ${feet} feet.`);
    }
}

let an = new Animal('Leia', 'Doge');
an.move(10);

an.setSpecies = 'Doggo';
console.log(an.getSpecies);

//Inheritance, implemented through the use of the extends keyword
class Dog extends Animal {
    bark():void {
        console.log('Arf Arf');
    }
}

let dog = new Dog('Leia', 'SheiPoo');
dog.bark();
dog.move(30);
//Since name is readonly, we cannot change it after its set
//dog.name = "bob";

//Typescript also has Abstract classes that act similarly to Java Abstract classes
abstract class Car{
    abstract drive(): void;
    alarm():void{
        console.log("BEEEEEEEEEEEEEEEEEEEEEPPP!!");
    }
}

//We can implement an abstract just like in java
class SportsCar extends Car{
    drive(): void{
        console.log("Drive fast!");
    }
}

let sc = new SportsCar();
sc.drive();
sc.alarm();

//Interfaces allows us to create contracts that othe classes/objects can implement, defined using the 
// interface keyword, you can include properties, and methods, you can also crate optional properties using ?
//Interfaces are not transpiled into JS, they are instead only used for type checking

interface User{
    username: string;
    password: string;
    phone?: number;
    login(): boolean;
}

let user: User;

user = {
    username: 'Bob',
    password: 'password',
    login: function(){return true}
};

user = {
    username: 'Phill',
    password: 'password',
    phone: 5554442222,
    login: () => {return true}
}