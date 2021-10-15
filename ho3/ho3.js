let container = document.getElementById('placeholder');

function populatePage(posts,res2){
   
    console.log(posts.forms);
        let post = document.createElement('div');
        post.innerHTML = `<h2 class="flex-child magenta">${posts.forms[0].name}</h2>`;
        post.innerHTML +=`<img class="flex-child green" src=${res2.sprites.front_default} />`;
        post.innerHTML += `<br/><img class="flex-child green" src=${res2.sprites.back_default} />`;
        container.append(post);
    
}


let apiURL = 'https://pokeapi.co/api/v2/pokemon/';
let apiURL2 = 'https://pokeapi.co/api/v2/pokemon-form/';







function submitForm(){

    let pokid = document.getElementById('pid');
    
    console.log(apiURL+pokid.value);

    (async () => {
        let req = await fetch(apiURL+pokid.value);
        let res = await req.json();

        let req2 = await fetch(apiURL2+pokid.value);
        let res2 = await req2.json();
        populatePage(res,res2);
        //console.log(res);
    })();

    /*let placeholder = document.getElementById('placeholder');   
    placeholder.innerHTML += "<br/> Hello " + document.getElementById('username').value +", Hobbies: "
    + document.getElementById('hobies').value  +", Color: " 
    + document.getElementById('color').value;;*/
 
}
