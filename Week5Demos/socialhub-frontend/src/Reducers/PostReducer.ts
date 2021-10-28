import {IPost} from "../Store/types";

//Later we will import our action types
import {GET_POSTS, ADD_POST} from '../Actions/ActionTypes';

const initialState:IPost[] = [];

type Action = {type: string, payload: object};

export const postReducer = (state:any = initialState, action:Action) => {
    switch(action.type){
        case GET_POSTS:
            return action.payload;
        default:
            return state;
    }
}