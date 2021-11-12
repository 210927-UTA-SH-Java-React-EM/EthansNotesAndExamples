import React, {useEffect, useState} from 'react';
import { IUser } from '../../Interfaces/IUser';

import '../PostComponent/Post.css';

//We are still exporting the component
//React.FC is the typescript type for React Function component
//  IUser stands for the type of props we are passing in
// user:IUser is also defining the props we are passing in
// the entire component is an arrow function
export const HobbiesComponent: React.FC<IUser>=(user:IUser) => {

    //First we will destructure our prop and get the username from it
    const {username} = user;

    //In function components, you use the useState hook to set state
    let [userName, setUsername] = useState('');
    let [hobbies, setHobbies] = useState('');

    //Use effect can be used similarly to componentDidMount
    useEffect(() => {
        console.log(username);
        setUsername(username);
        setHobbies("Hobbies include: Bike Riding, Kickin' it Ol' School, Various Narcotics");
    }, /* The array passed in here denotes states useEffect should be watching,
    an empty array, means that the component will call useEffect when it is rendered */[username])

    return(
        //JSX is slightly different from HTML, the syntax is the primary difference
        <div className="hobbies-container">
            <div className="hobbies-profile">
                <h3 className="hobies-username">{userName}</h3>
            </div>
            <div className="hobbies-content">
                <p>{hobbies}</p>
            </div>
        </div>
    );
}