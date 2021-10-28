//This is the file where actual business logic will occur, including calls to the api
import axios from 'axios';
import { IUser } from '../Store/types';
import {ADD_USER, LOGIN_USER} from './ActionTypes';

interface UserReg {
    first: string,
    last: string,
    email: string,
    username: string,
    password: string
}

interface UserLogin {
    username: string,
    password: string
}

export const newUser = (user:UserReg) => async (dispatch: any) => {
    //some register logic here
}

export const loginUser = (user:UserLogin) => async (dispatch: any) => {
    let loggedIn: IUser;

    try{
        //1. Create a post request to the backend server to attempt to login the user
        const res = await axios.post('http://localhost:8080/SocialHubWeekFour/api/login', user);

        //2. Is to handle the logged in user, or reject the login attempt
        loggedIn = {
            id: res.data.id,
            firstName: res.data.firstName,
            lastName: res.data.lastName,
            email: res.data.email,
            username: res.data.username,
            password: res.data.password
        }

        return dispatch({
            type: LOGIN_USER,
            payload: loggedIn
        });
    }
    catch(e){

        loggedIn = {
            id: -1,
            firstName: '',
            lastName: '',
            email: '',
            username: '',
            password: ''
        }

        return dispatch({
            type: LOGIN_USER,
            payload: loggedIn
        });
    }
}