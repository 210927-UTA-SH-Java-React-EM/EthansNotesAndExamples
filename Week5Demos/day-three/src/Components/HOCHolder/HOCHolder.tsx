import React, {useEffect, useState} from 'react';

import {data} from '../../data';

import { HOCList } from '../HOCList/HOCList';
import { Loading } from '../Loading/Loading';

const ListWithLoading = Loading(HOCList);

export const HOCHolder:React.FC<any> = () => {

    let arr:any[] = [];

    //Declare our state first like always
    //let [loading, setLoading] = useState(true);
    let [pass, setPass] = useState({loading: true, data:arr});

    useEffect(() => {
        setTimeout(() => {
            setPass({loading: false, data:data});
        }, 5000)
    }, [pass.loading]);

    return <ListWithLoading {...pass} />

}