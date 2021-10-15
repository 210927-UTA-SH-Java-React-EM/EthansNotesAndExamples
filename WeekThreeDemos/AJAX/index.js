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