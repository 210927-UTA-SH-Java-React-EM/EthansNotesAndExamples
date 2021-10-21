"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
//We create classes using the class keyword and an instance of that class using the new keyword
//TS supports getters and setters to access and set class memebers, the getter and setter are created by
//using the get and set keywords
var Animal = /** @class */ (function () {
    function Animal(name, species) {
        this.name = name;
        this.species = species;
    }
    Object.defineProperty(Animal.prototype, "getSpecies", {
        //create a getter for species
        get: function () {
            return this.species;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Animal.prototype, "setSpecies", {
        //create a setter for species
        set: function (sp) {
            this.species = sp;
        },
        enumerable: false,
        configurable: true
    });
    //methods
    Animal.prototype.move = function (feet) {
        console.log("The " + this.species + ", " + this.name + " moved a total of " + feet + " feet.");
    };
    return Animal;
}());
var an = new Animal('Leia', 'Doge');
an.move(10);
an.setSpecies = 'Doggo';
console.log(an.getSpecies);
//Inheritance, implemented through the use of the extends keyword
var Dog = /** @class */ (function (_super) {
    __extends(Dog, _super);
    function Dog() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Dog.prototype.bark = function () {
        console.log('Arf Arf');
    };
    return Dog;
}(Animal));
var dog = new Dog('Leia', 'SheiPoo');
dog.bark();
dog.move(30);
//Since name is readonly, we cannot change it after its set
//dog.name = "bob";
//Typescript also has Abstract classes that act similarly to Java Abstract classes
var Car = /** @class */ (function () {
    function Car() {
    }
    Car.prototype.alarm = function () {
        console.log("BEEEEEEEEEEEEEEEEEEEEEPPP!!");
    };
    return Car;
}());
//We can implement an abstract just like in java
var SportsCar = /** @class */ (function (_super) {
    __extends(SportsCar, _super);
    function SportsCar() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    SportsCar.prototype.drive = function () {
        console.log("Drive fast!");
    };
    return SportsCar;
}(Car));
var sc = new SportsCar();
sc.drive();
sc.alarm();
var user;
user = {
    username: 'Bob',
    password: 'password',
    login: function () { return true; }
};
user = {
    username: 'Phill',
    password: 'password',
    phone: 5554442222,
    login: function () { return true; }
};
