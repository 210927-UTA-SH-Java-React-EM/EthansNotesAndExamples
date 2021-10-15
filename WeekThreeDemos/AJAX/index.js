let container = document.getElementById('post-container');

function populatePage(posts){
    for(postObj of posts){
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.title}</h2><p>${postObj.body}</p>`;
        container.append(post);
    }
}

// AJAC Async JS and XML
//We are going to be using JSONPlaceHolder API

//https://jsonplaceholder.typicode.com/

let apiURL = 'https://jsonplaceholder.typicode.com/posts';

/*
//When our document loads we will make the request
//There are 4 steps to making an ajax request
(()=> {
    //step one: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    //step two: Set a callback function to readystatechange
    xhttp.onreadystatechange = getData = () => {
        //If the response is ready and it was successful
        if(xhttp.readyState === 4 && xhttp.status === 200){
            let res = JSON.parse(xhttp.responseText);
            console.log(res);
            populatePage(res);
        }
    }

    //step three: open the request
    xhttp.open('GET', apiURL);

    //step four: send the request
    xhttp.send();
})();
*/

/*
//Refactor the above with Fetch and promises
(() => {
    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => populatePage(data));
})();


//Lets take a look at the response headers
(function responseHeaders(){
    fetch(apiURL).then((res) => console.log(res.headers));
})();

//We can set request headers including an object in the fetch call
(function requestHeaders(){
    fetch(apiURL,
        {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then((res) => res.json())
        .then((json) => console.log(json));
})();

(function post(){
    let title = 'This is our title value';
    let body = 'This is our body value';
    let obj = {
        title,
        body,
        id: 1
    };

    fetch(apiURL,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(obj)
    })
    .then((res) => res.json())
    .then((json) => console.log(json));
})();

(function failedRequest(){
    fetch(apiURL, {
        method: 'GET',
        body: {}
    })
    .then((res) => res.json())
    .then((json) => console.log(json))
    .catch((err) => console.log('Do some logic if error occurs'));
})();
*/

//Refactor once more with async/await
(async () => {
    let req = await fetch(apiURL);
    let res = await req.json();
    populatePage(res);
})();

( async function post(){
    let title = 'This is our title value';
    let body = 'This is our body value';
    let obj = {
        title,
        body,
        id: 1
    }

    let req = await fetch(apiURL,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(obj)
    });

    let res = await req.json();
    console.log(res);
})();

(async function failedRequest(){
    try{
        let req = await fetch(apiURL, {
            method: 'GET',
            body: {}
        });
        let res = await req.json();
        console.log(res);
    } catch(e){
        console.log('An error occured');
    }
})();