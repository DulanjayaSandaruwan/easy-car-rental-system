import React from 'react'
import Navbar from "./Navbar";
import Sidenav from "./SideNav";
import { Route, Routes } from "react-router-dom";
import ManageCar from "../bodyComponents/ManageCar";
import {Box} from "@material-ui/core";
import {useStyles} from "./HeaderStyles";
import ManageDriver from "../bodyComponents/ManageDriver";
import Home from "../bodyComponents/home/Home";
import ManageCustomer from "../bodyComponents/ManageCustomer";

export default function HeaderComponent() {
    const classes = useStyles();
    return (
        <div>
            <Navbar/>
            <Sidenav/>
            <Box className={classes.wrapper}>
                <Routes>
                    <Route exact path="/" render={() => <Home/>}/>
                    <Route exact path="/manageCar" render={() => <ManageCar/>}/>
                    <Route exact path="/manageDriver" render={() => <ManageDriver/>}/>
                    <Route exact path="/manageCustomer" render={() => <ManageCustomer/>}/>
                </Routes>
            </Box>
        </div>
    )
}
