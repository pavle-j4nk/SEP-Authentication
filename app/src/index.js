import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {Button, Nav, Navbar, NavbarBrand, NavItem, NavLink} from "reactstrap";
import Notfound from "./notFound";
import Login from "./login";
import AuthService from "./authService";
import Home from "./home";

const routing = (
    <Router>
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand href="/">Scientific Center</NavbarBrand>
                <Nav className="mr-auto" navbar>
                    <NavItem>
                        <NavLink href="/">Home</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href = "/login">Login</NavLink>
                    </NavItem>
                    <NavItem>
                        <Button className="btn btn-primary" onClick={AuthService.logOut}>Logout</Button>
                    </NavItem>
                </Nav>
            </Navbar>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route path="/login" component={Login}/>
                <Route component={Notfound}/>
            </Switch>
        </div>
    </Router>
);

ReactDOM.render(routing, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
