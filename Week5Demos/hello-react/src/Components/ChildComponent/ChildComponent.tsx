import React from 'react';

export class ChildComponent extends React.Component<any, any>{

    constructor(props:any){
        super(props);
        this.state = {
            favColor: props.color
        }
    }

    render(){
        return(
            //Creating an h3, and setting the text color to our favorite color
            //Displaying our favorite color as text inside of the h3
            <h3 style={{color: this.state.favColor}}>{this.state.favColor}</h3>
        )
    }

}