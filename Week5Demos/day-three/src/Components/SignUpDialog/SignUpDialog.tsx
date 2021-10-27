import React, {useState, useEffect} from 'react';

import { WelcomeDialog } from '../WelcomeDialog/WelcomeDialog';

export const SignUpDialog: React.FC<any> = (props:any) => {

    let [login, setLogin] = useState('');

    const handleChange = (e:any) => {
        setLogin(e.target.value);
    }

    const handleSignup = () => {
        alert(`Welcome aboard, ${login}`);
    }

    return(
        <WelcomeDialog title="Mars Eploration Program"
                        message="How should we refer to you?">
            <input value={login} onChange={handleChange} />
            <button onClick={handleSignup}>Sign Me Up!</button>
        </WelcomeDialog>
            
    )

}