//This is the file where actual business logic will occur, including calls to the api
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
    //Some login logic here
}