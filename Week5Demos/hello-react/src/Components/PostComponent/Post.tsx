import React, {useEffect, useState} from 'react';
import { IUser } from '../../Interfaces/IUser';

import './Post.css';

//We are still exporting the component
//React.FC is the typescript type for React Function component
//  IUser stands for the type of props we are passing in
// user:IUser is also defining the props we are passing in
// the entire component is an arrow function
export const PostComponent: React.FC<IUser>=(user:IUser) => {

    //First we will destructure our prop and get the username from it
    const {username} = user;

    //In function components, you use the useState hook to set state
    let [userName, setUsername] = useState('');
    let [content, setContent] = useState('');

    //Use effect can be used similarly to componentDidMount
    useEffect(() => {
        console.log(username);
        setUsername(username);
        setContent("We are setting this text in the useEffect function");
    }, /* The array passed in here denotes states useEffect should be watching,
    an empty array, means that the component will call useEffect when it is rendered */[username])

    return(
        //JSX is slightly different from HTML, the syntax is the primary difference
        <div className="post-container">
            <div className="post-profile">
                <img className="post-image" src='https://www.pngitem.com/pimgs/m/30-307416_profile-icon-png-image-free-download-searchpng-employee.png'></img>
                <h3 className="post-username">{userName}</h3>
            </div>
            <div className="post-content">
                <p>{content}</p>
            </div>
        </div>
    );
}