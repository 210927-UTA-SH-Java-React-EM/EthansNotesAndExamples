import React from 'react';

import './FancyBorder.css';

export const FancyBorder: React.FC<any> = (props:any) => {
    return (
        <div className='fancy-border fancy-border-blue'>
            {props.children}
        </div>
    )
}