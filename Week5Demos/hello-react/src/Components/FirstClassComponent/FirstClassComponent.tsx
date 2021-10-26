import React from 'react';

//This creates a class based component with TS, the Component takes in two properties
//props and state, we will take a deeper look later
export class FirstClassComponent extends React.Component<{}, {}>{
    
    words:string = "I am stored in a var";

    //The class must contain a render method
    render(){
        //The render method returns JSX/TSX
        //We can bind data in a React component using {} notation
        return(
            <div>
                <h2>This is a class component</h2>
                <p>{this.words}</p>
            </div>
        )
    }

}