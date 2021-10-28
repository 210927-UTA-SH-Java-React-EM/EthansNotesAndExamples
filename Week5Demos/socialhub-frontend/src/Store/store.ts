import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';

//We will create this in a second
import reducer from '../Reducers';

import {AppState} from './types';

const initialState:AppState = {
    user: {
        id: 0,
        firstName: '',
        lastName: '',
        email: '',
        username: '',
        password: ''
    },
    posts: []
}

const middleWare = [thunk];

export const store = createStore(reducer, initialState, applyMiddleware(...middleWare));