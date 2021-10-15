let color = 'gray';

//Set the background to gray to start
let div = document.getElementById('colorMe');
div.style.backgroundColor = color;
div.style.height = '200px';

let button = document.getElementById('clickMe');
button.addEventListener('click', waitForLoading);
let panic = document.getElementById('panic');
panic.addEventListener('click', stopTimer);

let timeout;

function waitForLoading(){
    console.log('Loading...');
    button.innerHTML='Loading...';
    //Wait 2 seconds and then change the color
    timeout = setTimeout(()=> {
        button.innerHTML = 'Click Me';
        color = (color === 'gray') ? 'green' : 'gray';
        div.style.backgroundColor = color; 
    }, 2000);
}

function stopTimer(){
    console.log('Cancel the color change');
    clearTimeout(timeout);
    button.innerHTML = 'Click Me';
}

let seconds = 0;
let interval;

let start = document.getElementById('start');
start.addEventListener('click', startTime);
let stop = document.getElementById('stop');
stop.addEventListener('click', stopTime);

function startTime(){
    console.log('start');
    seconds = 0;
    document.getElementById('time').innerHTML = '0:00';
    interval = setInterval(() => {
        seconds++;
        let timer = `${Math.floor(seconds/60)}:${new String(seconds%60).padStart(2, '0')}`;
        document.getElementById('time').innerHTML = timer;
    }, 1000);
}

function stopTime(){
    clearInterval(interval);
}