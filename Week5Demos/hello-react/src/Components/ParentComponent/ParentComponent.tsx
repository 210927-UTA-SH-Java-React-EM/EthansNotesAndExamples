import React from 'react';

import { ChildComponent } from '../ChildComponent/ChildComponent';

//The props can be of type any, the state can be of type any
export class ParentComponent extends React.Component<any, any>{

    state = {
        color: 'red'
    }

    public render(){
        return(
            <div>
                <h1>My favorite color is</h1>
                <ChildComponent color={this.state.color}/>
            </div>
        )
    }

}