import React, { useState } from 'react';
import AuthService from "./authService";

const Login = () => {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [error, setError] = useState();


    const performLogin = () => {
        setError(undefined);

        AuthService.login({ username, password })
            .then(response => {
                localStorage.setItem("userInfo", JSON.stringify(response.data));
                window.location.href = '/';
            }).catch(e => {
            setError("Bad credentials");
        })

    }

    return (
        <div className="page-login">
            <div className="ui centered grid container">
                <div className="nine wide column">
                    {error &&
                    <div className="ui icon warning message">
                        <i className="lock icon"></i>
                        <div className="content">
                            <div className="header">
                                Login failed!
                            </div>
                            <p>{error}</p>
                        </div>
                    </div>
                    }
                    <div className="ui fluid card">
                        <div className="content">
                            <form className="ui form" method="POST" onSubmit={e => { e.preventDefault(); performLogin() }}>
                                <div className="field">
                                    <label>User</label>
                                    <input onChange={e => setUsername(e.target.value)} type="text" name="user" placeholder="User" />
                                </div>
                                <div className="field">
                                    <label>Password</label>
                                    <input onChange={e => setPassword(e.target.value)} type="password" name="pass" placeholder="Password" />
                                </div>
                                <button className="ui primary labeled icon button" type="submit">
                                    <i className="unlock alternate icon"></i>
                                    Login
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;