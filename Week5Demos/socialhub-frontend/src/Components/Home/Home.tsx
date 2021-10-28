import React, {useEffect, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {getPosts} from '../../Actions/PostActions';
import {useHistory} from 'react-router-dom';

import {Post} from '../Post/Post';
import {CreatePost} from '../CreatePost/CreatePost';

import './Home.css';

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    const history = useHistory();

    let [posts, setPosts] = useState([]);

    useEffect(() => {
        if(appState.user.id <= 0){
            history.push('/');
        }
        console.log(appState);
        loadPosts();
        setPosts(appState.posts);
    }, [appState.posts.length]);

    const loadPosts = async () => {
        await dispatch(
            getPosts()
        );
    }

    return (
        <div className="home-page">
            <div className="home-container">
                <h1>Welcome {appState.user.username}</h1>
                <CreatePost />
                {posts ? posts.map((post:any) => {
                    return(
                        <Post {...post} key={post.postId} />
                    );
                }) : <h1>I am being silly</h1>}
            </div>
        </div>
    )

    /*
    {appState.posts.map((post:any) => {
                    return(
                        <Post {...post} key={post.postId} />
                    );
                })}
    */

}