import React, {useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {getPosts} from '../../Actions/PostActions';

import './Home.css';

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    useEffect(() => {
        console.log(appState);
        loadPosts();
    }, [appState.posts.length]);

    const loadPosts = async () => {
        await dispatch(
            getPosts()
        );
    }

    return (
        <div className="home-page">
            <div className="home-container">
                <h1>Welcome to social hub</h1>
                {appState.posts.map((post:any) => {
                    return(
                        <h1>Placeholder</h1>
                    );
                })}
            </div>
        </div>
    )

}