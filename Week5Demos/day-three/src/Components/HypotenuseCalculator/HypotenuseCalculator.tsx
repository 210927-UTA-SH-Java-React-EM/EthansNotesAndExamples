import React, {useState} from 'react';

import { ResultDisplay } from '../ResultDisplay/ResultDisplay';
import { SideInput } from '../SideInput/SideInput';

export const HypotenuseCalculator: React.FC<any> = () => {

    //First we can create some state
    let [values, setValues] = useState({first: 0, second: 0});
    let [result, setResult] = useState(0);

    const calculateResult = (e:any) => {

        //Using rest operator and enhanced object literals from JS to set the value
        //of the correct value based on the name of the input field
        setValues(
            {
                ...values,
                [e.target.name]: e.target.value
            }
        );

        //console.log(values);
        let result = Math.sqrt(
            Math.pow(values.first, 2) + Math.pow(values.second, 2)
        );

        result = Math.round(result * 100)/100;

        setResult(result);

    }


    //In react we can conditionally render html based off of if statements or ternary operators
    return (
        <div>
            <h3>Calculator</h3>
            <SideInput name="first" onChange={calculateResult}/>
            <SideInput name="second" onChange={calculateResult}/>
            <ResultDisplay values={values} result={result} />
        </div>
    );

}