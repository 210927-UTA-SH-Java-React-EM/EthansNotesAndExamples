"use strict";
//Class Decorator: these are declared before a class that are applied to the constructor
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
//Create the decorator
function frozen(constructor) {
    console.log('--Frozen decorator invoked--');
    //Prevents the elements from being altered
    //Useful for making a class immutable
    Object.freeze(constructor);
}
//Method Decorator is declared before a method, and is applied to the Property Discriptor
//Property Discriptor: a simple js object associated with each property of the object that contains
//information about that property, such as is value
//Property Decorator: used to listen to state changes on a class
//Paremeter Decorator: this is declared before a parameter declaration, applied to the function
//Create the decorator
function enumerable(value) {
    //When this function is called, it modifies the enumeranle property of the property discriptor
    return function (target, propertyKey, descriptor) {
        descriptor.enumerable = value;
    };
}
//Create the property decorator
function logProperty(target, key) {
    var _val = target[key];
    var getter = function () {
        console.log("Get: " + key + " => " + _val);
        return _val;
    };
    var setter = function (newVal) {
        console.log("Set: " + key + " => " + newVal);
        _val = newVal;
    };
    if (delete target[key]) {
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}
//Create the parameter decorator
function required(target, propertyKey, parameterIndex) {
    console.log('hey this key is required!');
}
var Greeter = /** @class */ (function () {
    function Greeter(name) {
        console.log('--constructor invoked--');
        this.name = name;
    }
    Greeter.prototype.greet = function () {
        console.log("Hello " + this.name);
    };
    Greeter.prototype.welcome = function (name) {
        console.log("Welcome, " + name);
    };
    __decorate([
        logProperty,
        __metadata("design:type", String)
    ], Greeter.prototype, "name", void 0);
    __decorate([
        enumerable(true),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], Greeter.prototype, "greet", null);
    __decorate([
        __param(0, required),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [String]),
        __metadata("design:returntype", void 0)
    ], Greeter.prototype, "welcome", null);
    Greeter = __decorate([
        frozen,
        __metadata("design:paramtypes", [String])
    ], Greeter);
    return Greeter;
}());
var mc = new Greeter('MC');
mc.name = 'Billy';
mc.greet();
for (var a in mc) {
    console.log(a);
}
mc.welcome('Billy');
