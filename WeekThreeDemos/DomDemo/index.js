let posts = [
    {
        username: 'rick',
        content: "Morty and I will be doing space stuff today, don't try to bother us."
    },
    {
        username: 'morty',
        content: 'I will never be doing space stuff with rick again!'
    },
    {
        username: 'summer',
        content: 'Grandpa rrick never lets me go on adventures anymore'
    }
];

//We can grab the div we want to store the posts in
let container = document.getElementById('post-container');

console.log(container);

for(postObj of posts){
    let post = document.createElement('div');
    post.innerHTML = `<h2>${postObj.username}</h2>
                      <p>${postObj.content}</p>`;
    console.log(post);
    container.append(post);
}