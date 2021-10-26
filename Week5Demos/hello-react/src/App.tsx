import React from 'react';

import { FirstClassComponent } from './Components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './Components/ParentComponent/ParentComponent';

import {User} from './Components/UserComponent/User';

import './App.css';

function App() {
  return (
    <div>
      <h1>Hello World</h1>
      <FirstClassComponent />
      <ParentComponent />
      <User />
    </div>
  );
}

export default App;
