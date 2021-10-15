let bubbleElements = document.getElementsByClassName('bubble');

for(el of bubbleElements){
    el.addEventListener('click', bubble);
    el.addEventListener('click', viewTarget);
    el.addEventListener('click', stopImProp);
}

function bubble(){
    alert(`Bubbling ${this.tagName}`);
}

let captureElements = document.getElementsByClassName('capture');

for(el of captureElements){
    el.addEventListener('click', alertName, true);
}

function alertName(){
    alert(`Captured ${this.tagName}`);
}

//We can view the target element from the event
function viewTarget(event){
    console.log(event.target);
}

//You can stop the propagation of events with stopPropagation
function stopProp(event){
    event.stopPropagation();
}

//If you hit the case where stopPropagation does not work as expected you can use stopImmediatePropagation
function stopImProp(event){
    event.stopImmediatePropagation();
}

function printPressed(event){
    console.log(`Key pressed in username field: ${event.key}`);
}

let passwordField = document.getElementById('password');
passwordField.addEventListener('keydown', passwordPress);

function passwordPress(e){
    console.log(`Key pressed in password field: ${e.key}`);
}

//If you wanted to do some custom logic before submitting a form, you can create an event listener on the submit event

let login = document.getElementById('login');

login.addEventListener('submit', submitForm);

function submitForm(e){
    //We can prevent the form from reloading the page with e.preventDefault()
    //e.preventDefault();
    console.log('We prevented the default functionality of the form');
    console.log(`The username was ${document.getElementById('username').value}`);
    console.log(`The password was ${document.getElementById('password').value}`);
    login.reset();
}