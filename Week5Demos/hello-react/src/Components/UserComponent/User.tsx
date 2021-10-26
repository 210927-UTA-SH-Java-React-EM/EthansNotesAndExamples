import React from 'react';

import { PostComponent } from '../PostComponent/Post';
import { IUser } from '../../Interfaces/IUser';

//In this class, we can pass props of type any
//The state will be of type IUser
export class User extends React.Component<any, IUser>{

    constructor(props:any){
        super(props);

        this.state = {
            firstName: '',
            lastName: '',
            username: '',
            email: ''
        };
    }

    //This lifecycle method, is typically used to fetch some information
    componentDidMount(){
        //Imagine that we are making some call to an api to populate data here
        this.setState({
            firstName: 'Rick',
            lastName: 'Sanchez',
            username: 'ricketyrick',
            email: 'rickc137@rickmail.com'
        });
    }

    render(){
        return(
            <div>
                <h2>{this.state.firstName} {this.state.lastName}</h2>
                <h3>{this.state.username}</h3>
                <h3>{this.state.email}</h3>
                <PostComponent {...this.state} />
            </div>
        )
    }

}