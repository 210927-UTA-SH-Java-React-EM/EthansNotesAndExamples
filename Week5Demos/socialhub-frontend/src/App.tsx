import React from 'react';

import {HashRouter as Router, Route, Switch} from 'react-router-dom';
import {Login} from './Components/Login/Login';
import {Home} from './Components/Home/Home';

import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            <Login />
          </Route>
          <Route exact path="/home">
            <Home />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;