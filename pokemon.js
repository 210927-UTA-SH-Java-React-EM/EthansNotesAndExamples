const url = 'https://pokeapi.co/api/v2/pokemon/';
let form = document.getElementById('pokemon');
let name = document.getElementById('pokemon-name');
let image = document.getElementById('image');
let answer = document.getElementById('answer');
let answer_p = document.getElementById('ans-p');
let pokemon;

name.focus();


function getRandomPokemon() {
  let random = Math.floor(Math.random() * 492 + 1);
  fetch(url + random)
    .then((ret => ret.json()))
    .then((json => {
      image.innerHTML = `<img src='${json['sprites']['front_default']}' style='width: 200px; height: auto; filter: brightness(0%);'>`;
      pokemon = json;
      console.log(json);
    }))
}

getRandomPokemon();

form.addEventListener('submit', (event) => {
  event.preventDefault();
  
  if (event.submitter.id == 'new') {
    answer.style.visibility = 'hidden';
    name.value = "";
    name.focus();
    getRandomPokemon();
  } else {
    image.innerHTML = `<img src='${pokemon['sprites']['front_default']}' style='width: 200px; height: auto;'>`;
    answer.style.visibility = 'visible';
    if (name.value.toLowerCase() == pokemon['name']) {
      answer.style.color = 'green';
      answer_p.innerText = "Correct!";
    } else {
      answer.style.color = 'red';
      answer_p.innerText = "Incorrect! It was " + pokemon['name'];
    }
  } 
});
