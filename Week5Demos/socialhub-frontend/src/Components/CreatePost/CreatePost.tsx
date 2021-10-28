import React, {useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';

import { addPost } from '../../Actions/PostActions';

export const CreatePost:React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();


    let [content, setContent] = useState('');

    const handleChange = (e:any) => {
        setContent(e.target.value);
        console.log(content);
    }

    let newPost = {
        userId: appState.user.id,
        username: appState.user.username,
        content
    }

    const sendPost = () => {
        dispatch(
            addPost(newPost)
        );
    }

    return (
        <div>
            <form>
                <textarea placeholder="Your post here" onChange={handleChange}/>
            </form>
            <button onClick={sendPost}>Submit Post</button>
        </div>
    )

}