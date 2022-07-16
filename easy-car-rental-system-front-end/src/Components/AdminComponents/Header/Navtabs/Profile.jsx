import React, {useState} from "react";
import {Avatar, Box, Button, ListItem, ListItemIcon, ListItemText, Menu, MenuItem} from "@material-ui/core";
import SettingsIcon from '@mui/icons-material/Settings';
import LogoutIcon from '@mui/icons-material/Logout';
import {useStyles} from "../HeaderStyles";

export default function Profile() {
    const classes = useStyles();
    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };
    const dropDownData = [{label: "settings", icon: <SettingsIcon/>}, {label: "Logout", icon: <LogoutIcon/>},];

    return (<Box>
        <Button
            id="basic-button"
            aria-controls={open ? 'basic-menu' : undefined}
            aria-haspopup="true"
            aria-expanded={open ? 'true' : undefined}
            onClick={handleClick}
            startIcon={<Avatar
                src="https://media-exp2.licdn.com/dms/image/C4D03AQEpdlQCLhvzzA/profile-displayphoto-shrink_800_800/0/1656002497819?e=1663200000&v=beta&t=HLl4pA8fpefmdx1ToFEBlbbOF2ptHIe3D6-XPxx-9qM"
                className={classes.navAvatar}></Avatar>}
        >
        </Button>

        <Menu
            id="basic-menu"
            anchorEl={anchorEl}
            open={open}
            onClose={handleClose}
            MenuListProps={{
                'aria-labelledby': 'basic-button',
            }}
        >
            {dropDownData.map((item, i) => (<MenuItem key={i} component={ListItem} onClick={handleClose}>
                <ListItemIcon>{item.icon}</ListItemIcon>
                <ListItemText>{item.label}</ListItemText>
            </MenuItem>))}

        </Menu>
    </Box>)
}
