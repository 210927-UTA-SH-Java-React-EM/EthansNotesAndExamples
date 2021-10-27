import React from 'react';


//This react component will be lifting state for us, by changing the values of the value state
//in the parent component
export const SideInput: React.FC<any> = (props:any) => {
    return (
        <div>
            Enter {props.name} side value:
            <input name={props.name} type="number" onChange={props.onChange} />
        </div>
    )
}