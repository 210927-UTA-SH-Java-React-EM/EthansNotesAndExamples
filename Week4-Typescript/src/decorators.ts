//Class Decorator: these are declared before a class that are applied to the constructor

//Create the decorator
function frozen(constructor: Function){
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
function enumerable(value: boolean){
    //When this function is called, it modifies the enumeranle property of the property discriptor
    return function(
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor
    ){
        descriptor.enumerable = value;
    }
}

//Create the property decorator
function logProperty(target: any, key:string){
    var _val = target[key];
    var getter = function(){
        console.log(`Get: ${key} => ${_val}` );
        return _val;
    }

    var setter = function (newVal: any){
        console.log(`Set: ${key} => ${newVal}`);
        _val = newVal;
    }

    if(delete target[key]){
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}

//Create the parameter decorator
function required(
    target: Object,
    propertyKey: string | symbol,
    parameterIndex: number
) {
    console.log('hey this key is required!');
}

@frozen
class Greeter{
    @logProperty
    name:string;
    constructor(name:string){
        console.log('--constructor invoked--');
        this.name = name;
    }

    @enumerable(true)
    greet(){
        console.log(`Hello ${this.name}`);
    }

    welcome(@required name:string){
        console.log(`Welcome, ${name}`);
    }
}

let mc = new Greeter('MC');
mc.name = 'Billy';
mc.greet();

for(let a in mc){
    console.log(a);
}

mc.welcome('Billy');