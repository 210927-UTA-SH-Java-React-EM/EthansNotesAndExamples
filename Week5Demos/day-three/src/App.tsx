import React from 'react';

import { HypotenuseCalculator } from './Components/HypotenuseCalculator/HypotenuseCalculator';
import { PostContainer } from './Components/PostContainer/PostContainer';

import {data} from './data';

import './App.css';

function App() {
  return (
    <div>
      <HypotenuseCalculator />
      <PostContainer data={data} />
    </div>
  );
}

export default App;
