import {IPost} from "../Store/types";

//Later we will import our action types
import {GET_POSTS, ADD_POST} from '../Actions/ActionTypes';

let initialState:IPost[] = [];

type Action = {type: string, payload:IPost};

export const postReducer = (state:any = initialState, action:Action) => {
    switch(action.type){
        case GET_POSTS:
            return action.payload;
        case ADD_POST:
            return [action.payload, ...state];
        default:
            return state;
    }
}