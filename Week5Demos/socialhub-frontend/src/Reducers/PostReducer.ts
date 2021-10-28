import {IPost} from "../Store/types";

//Later we will import our action types

const initialState:IPost[] = [];

type Action = {type: string, payload: object};

export const postReducer = (state:IPost[] = initialState, action:Action) => {
    switch(action.type){
        default:
            return state;
    }
}