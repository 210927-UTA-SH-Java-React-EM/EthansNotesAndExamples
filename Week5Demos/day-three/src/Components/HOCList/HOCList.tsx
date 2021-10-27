import React from 'react';

export const HOCList:React.FC<any> = (props:any) => {

    const {list} = props;

    if(!list) return null;

    return(
        <ul>
            {list.map((item:any) => {
                return <li key={item.postId}>{item.content}</li>
            })}
        </ul>
    );
}