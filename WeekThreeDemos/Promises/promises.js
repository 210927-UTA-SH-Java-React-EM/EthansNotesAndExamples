//Basic Promise Syntax
let promise = new Promise(function(resolve, reject){
    //Add logic for the executor in here
    const x = 5;
    const y = 3;

    if(x>= y){
        resolve(x);
    } else {
        reject();
    }
});

promise
    .then((x) => {return x*2})
    .then((y) => {return y * 3})
    .then((z) => console.log(z*4));

promise
    .then(() => console.log('We resolved'))
    .catch(() => console.log('We rejected'))
    .finally(() => console.log('Should run no matter what'));