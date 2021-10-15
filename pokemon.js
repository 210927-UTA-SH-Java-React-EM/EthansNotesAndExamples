const url = 'https://pokeapi.co/api/v2/pokemon/';
let form = document.getElementById('pokemon');
let name = document.getElementById('pokemon-name');
let image = document.getElementById('image');
let answer = document.getElementById('answer');
let answer_p = document.getElementById('ans-p');
let pokemon;
name.focus();

function setError(string) {
  error.innerText = string;
}

function getRandomPokemon() {
  let random = Math.floor(Math.random() * 385 + 1);
  console.log(random);
  fetch(url + random)
    .then((ret => ret.json()))
    .then((json => {
      let blackedout = `<img src='${json['sprites']['front_default']}' style='width: 200px; height: auto; filter: brightness(0%);'>`;
      image.innerHTML = blackedout;
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