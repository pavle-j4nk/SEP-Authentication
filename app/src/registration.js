import React, { useState } from 'react';
import AuthService from "./authService";

const Registration = () => {
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [error, setError] = useState();


    const performRegistration = () => {
        setError(undefined);

        AuthService.register({ email, password, firstName, lastName });

    };

    return (
        <div className="page-registration">
            <div className="ui centered grid container">
                <div className="nine wide column">
                    {error &&
                    <div className="ui icon warning message">
                        <i className="lock icon"></i>
                        <div className="content">
                            <div className="header">
                                Registration failed
                            </div>
                            <p>{error}</p>
                        </div>
                    </div>
                    }
                    <div className="ui fluid card">
                        <div className="content">
                            <form className="ui form" method="POST" onSubmit={e => { e.preventDefault(); performRegistration() }}>
                                <div className="field">
                                    <label>First name</label>
                                    <input onChange={e => setFirstName(e.target.value)} type="text" name="firstName" placeholder="User" />
                                </div>
                                <div className="field">
                                    <label>Last name</label>
                                    <input onChange={e => setLastName(e.target.value)} type="text" name="lastName" placeholder="User" />
                                </div>
                                <div className="field">
                                    <label>Email</label>
                                    <input onChange={e => setEmail(e.target.value)} type="text" name="email" placeholder="User" />
                                </div>
                                <div className="field">
                                    <label>Password</label>
                                    <input onChange={e => setPassword(e.target.value)} type="password" name="pass" placeholder="Password" />
                                </div>
                                <button className="ui primary labeled icon button" type="submit">
                                    <i className="unlock alternate icon"></i>
                                    Sign up
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Registration;