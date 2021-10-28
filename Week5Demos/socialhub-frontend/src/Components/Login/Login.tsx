import React, {useState, useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import { loginUser } from '../../Actions/UserActions';
import {useHistory, Link} from 'react-router-dom';
import './Login.css';

export const Login:React.FC<any> = () => {

    //First we will pull in the application level state with useSelector
    const appState = useSelector<any, any>((state) => state);
    //Create the dispatcher to dispatch actions
    const dispatch = useDispatch();

    //We will setup useHistory to naviate using JS
    const history = useHistory();

    //Set up our component level state, that other components don't need to know about
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');

    useEffect(() => {
        console.log(appState);
        if(appState.user.id > 0){
            history.push('/home');
        }
    }, [appState]);

    //Update the username or password state with whatever is typed in the fields
    const handleChange = (e:any) => {
        if(e.target.name === 'username'){
            setUsername(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }

    //We need a function to actually handle the login
    const login = async () => {
        await dispatch(
            loginUser({username, password})
        );
    }

    return(
        <div className="login">
            <div className="text-container">
                <h1 className="login-h1">Welcome to Socialhub!</h1>
                <h2>Sign in to see what everyone's up to!</h2>
            </div>
            <form className="login-form">
                <div className="input-div">
                    <h4 className="login-h4">Enter Username</h4>
                    <input className="login-input" autoComplete="off" type="text" name="username"
                        placeholder="Username" onChange={handleChange} id="username"/>
                </div>
                <div className="input-div">
                    <h4 className="login-h4">Enter Password</h4>
                    <input className="login-input" type="password" name="password"
                        placeholder="Password" onChange={handleChange} id="password"/>
                </div>
            </form>
            <button className="login-button" onClick={login}>Login</button>
        </div>
    )

}