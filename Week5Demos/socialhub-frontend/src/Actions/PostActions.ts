import {GET_POSTS, ADD_POST} from './ActionTypes';

interface NewPost{
    userId: number,
    content: string
};

export const addPost = (post:NewPost) => async (dispatch:any) => {
    //New post logic here
}

export const getPosts = () => async (dispatch:any) => {
    //Get all post logic here
}