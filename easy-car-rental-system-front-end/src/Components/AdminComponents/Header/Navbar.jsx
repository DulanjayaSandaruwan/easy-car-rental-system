import React from 'react';
import {AppBar, Box, Button, makeStyles, Menu, MenuItem, Toolbar, Typography} from "@material-ui/core";
import Profile from "./Navtabs/Profile";

const useStyles = makeStyles((theme) => ({
    toolbar: {
        display: "flex",
        flexFlow: "row wrap",
        justifyContent: "space-between",
    },
    logo: {
        color: "white",
    }
}))

export default function Navbar() {
    const classes = useStyles()
    return (
        <AppBar position="static">
            <Toolbar className={classes.toolbar}>
                <Typography variant="h6" className={classes.logo}>
                    Admin Dashboard
                </Typography>
                <Box>
                    <Profile/>
                </Box>
            </Toolbar>
        </AppBar>
    )
}

