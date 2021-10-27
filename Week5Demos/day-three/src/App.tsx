import React from 'react';

import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';

import { HypotenuseCalculator } from './Components/HypotenuseCalculator/HypotenuseCalculator';
import { PostContainer } from './Components/PostContainer/PostContainer';
import { HOCHolder } from './Components/HOCHolder/HOCHolder';
import { WelcomeDialog } from './Components/WelcomeDialog/WelcomeDialog';
import { SignUpDialog } from './Components/SignUpDialog/SignUpDialog';

import {data} from './data';

import './App.css';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/hyp">
          <HypotenuseCalculator />
        </Route>
        <Route path="/posts">
          <PostContainer data={data} />
        </Route>
        <Route path="/HOC">
          <HOCHolder />
        </Route>
        <Route path="/welcome">
          <SignUpDialog />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
