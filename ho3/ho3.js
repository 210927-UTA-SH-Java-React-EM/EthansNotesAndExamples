let container = document.getElementById('placeholder');

function populatePage(posts){
    for(postObj of posts){
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.title}</h2><p>${postObj.body}</p>`;
        container.append(post);
    }
}


let apiURL = 'https://pokeapi.co/api/v2/pokemon/';






function submitForm(){

    let pokid = document.getElementById('pid');
    
    console.log(apiURL+pokid.value);

    async () => {
        let req = await fetch(apiURL+pokid.value);
        let res = await req.json();
        populatePage(res);
        //console.log(res.);
    };

    /*let placeholder = document.getElementById('placeholder');   
    placeholder.innerHTML += "<br/> Hello " + document.getElementById('username').value +", Hobbies: "
    + document.getElementById('hobies').value  +", Color: " 
    + document.getElementById('color').value;;*/
 
}
