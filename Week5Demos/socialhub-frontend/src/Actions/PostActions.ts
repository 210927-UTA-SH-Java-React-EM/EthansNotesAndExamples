import {GET_POSTS, ADD_POST} from './ActionTypes';

import axios from 'axios';

interface NewPost{
    userId: number,
    content: string
};

export const addPost = (post:NewPost) => async (dispatch:any) => {
    //New post logic here
}

export const getPosts = () => async (dispatch:any) => {
    
    try{
        let res = await axios.get('http://localhost:8080/SocialHubWeekFour/api/posts');
        console.log(res.data);
        return dispatch({
            type: GET_POSTS,
            payload: res.data
        });
    } catch(e){
        console.log("uh oh");
        return dispatch({
            type: GET_POSTS,
            payload: []
        });
    }

}