import React from 'react';
import {AppBar, Box, Hidden, IconButton, Toolbar, Typography} from "@material-ui/core";
import Profile from "./navtabs/Profile";
import Notification from "./navtabs/Notification";
import {useStyles} from "./HeaderStyles";
import MenuIcon from "@material-ui/icons/Menu";

export default function Navbar({handleDrawerOpen}) {
    const classes = useStyles()
    return (<AppBar position="static">
            <Toolbar className={classes.toolbar}>
                <Typography variant="h6" className={classes.logo}>
                    Admin Dashboard
                </Typography>
                <Hidden smDown>
                    <Box style={{ display: "flex" }}>
                        <Notification />
                        <Profile />
                    </Box>
                </Hidden>
                <Hidden mdUp>
                    <IconButton color='inherit' onClick={handleDrawerOpen}>
                        <MenuIcon/>
                    </IconButton>
                </Hidden>
            </Toolbar>
        </AppBar>)
}

