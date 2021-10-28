import {GET_POSTS, ADD_POST} from './ActionTypes';

import axios from 'axios';

interface NewPost{
    userId: any,
    username: any,
    content: any
};

export const addPost = (post:NewPost) => async (dispatch:any) => {

    console.log("in the post actions add post");
    console.log(post);

    try{
        let newPost = {
            userId: post.userId,
            content: post.content
        }

        let res = await axios.post('http://localhost:8080/SocialHubWeekFour/api/posts', newPost);
        return dispatch({
            type: ADD_POST,
            payload: {
                postId: 0,
                username: post.username,
                content: post.content
            }
        });
    }
    catch (e){
        console.log(e);
    }
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