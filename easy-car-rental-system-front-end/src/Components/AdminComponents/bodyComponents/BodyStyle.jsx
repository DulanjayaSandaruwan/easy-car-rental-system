import React from "react";
import {makeStyles} from "@material-ui/core";
import {blueGrey} from "@material-ui/core/colors";

export const useStyle = makeStyles((theme) => ({
    section: {
        marginTop: theme.spacing(3, 0),
    },

    //page
    pageTitle: {
        color: blueGrey["800"],
        marginBottom: theme.spacing(2),
        textTransform: "uppercase"
    }, pageSubTitle: {
        color: blueGrey["500"],
        margin: theme.spacing(1, 0),
    },

    // Home
    cardLable:{
        textTransform: "uppercase",
        color: blueGrey[500],
        textAlign: "center",
        margin: theme.spacing(1, 0),
        [theme.breakpoints.down("xs")]:{
          fontsize: "0.8rem",
        },
    },
    cardTitle:{
        textTransform: "capitalize",
        color: blueGrey[800],
        textAlign: "center",
        margin: theme.spacing(1, 0),
        [theme.breakpoints.down("xs")]:{
            fontsize: "1.8rem",
        },
    },
    ratioBtn:{
        fontsize: "1rem",
        fontWeight: "bold"
    },
}))
