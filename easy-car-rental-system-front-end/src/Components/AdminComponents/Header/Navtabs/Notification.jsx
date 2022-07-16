import React, {useState} from "react";
import {Avatar, Badge, Box, IconButton, List, ListItem, ListItemIcon, ListItemText, Menu} from "@material-ui/core";
import NotificationsIcon from '@mui/icons-material/Notifications';
import {useStyles} from "../HeaderStyles";

export default function Notification() {
    const classes = useStyles();
    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    const dropDownData = [
        {label: "Admin", desc: "Accept your booking request..."},
        {label: "Admin", desc: "Reject your booking request..."}
    ];

    return (<Box>
        <IconButton
            id="basic-button"
            aria-controls={open ? 'notification' : undefined}
            aria-haspopup="true"
            aria-expanded={open ? 'true' : undefined}
            onClick={handleClick}
            color="inherit"
        >
            <Badge badgeContent={1} color="secondary">
                <NotificationsIcon/>
            </Badge>

        </IconButton>

        <Menu
            id='Notification'
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}>
            <List className={classes.navList}>
                {dropDownData.map((item, i) => (<ListItem key={i} onClick={handleClose}>
                    <ListItemIcon>
                        <Avatar className={classes.ulAvatar}>
                            {item.label[0].toUpperCase()}
                        </Avatar>
                    </ListItemIcon>
                    <ListItemText
                        primary={item.label}
                        secondary={item.desc}></ListItemText>
                </ListItem>))}
            </List>
        </Menu>
    </Box>);
}
