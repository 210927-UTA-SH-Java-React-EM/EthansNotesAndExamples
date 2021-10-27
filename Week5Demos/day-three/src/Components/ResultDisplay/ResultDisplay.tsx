import React from 'react';

export const ResultDisplay: React.FC<any> = (props:any) => {
    return (
        <p>
            {props.values.first && props.values.second ? `Result is: ${props.result}`:
            'Enter both numbers for a result'}
        </p>
    )
}