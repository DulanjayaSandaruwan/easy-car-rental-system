import React from "react";
import {Drawer, Hidden, Typography} from "@material-ui/core";
import {useStyles} from "./HeaderStyles";

export default function Sidenav() {
    const classes = useStyles();
    const [mobileOpen, setMobileOpen] = React.useState(false);
    const handleDrawerOpen = () => {
        setMobileOpen(!mobileOpen);
    }
    return (
        <nav className={classes.drawer} aria-label='mailbox folders'>
            {/* The implementation can be swapped with js to avoid SEO duplication of links. */}
            <Hidden smUp implementation='css'>
                <Drawer
                    variant='temporary'
                    anchor={"left"}
                    open={mobileOpen}
                    onClose={handleDrawerOpen}
                    classes={{
                        paper: classes.drawerPaper,
                    }}
                    ModalProps={{
                        keepMounted: true, // Better open performance on mobile.
                    }}>
                    <Typography variant="h6">Hello Dulan !</Typography>
                </Drawer>
            </Hidden>
            <Hidden xsDown implementation='css'>
                <Drawer
                    classes={{
                        paper: classes.drawerPaper,
                    }}
                    variant='permanent'
                    open>
                    <Typography variant="h6">Hello Sonali !</Typography>
                </Drawer>
            </Hidden>
        </nav>
    );
}
