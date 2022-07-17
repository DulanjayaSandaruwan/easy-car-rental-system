import React from 'react'
import {Box, Grid, makeStyles, Typography} from "@material-ui/core";
import {blueGrey} from "@material-ui/core/colors";

const useStyle = makeStyles((theme) => ({
    section:{
        marginTop:theme.spacing(3, 0),
    },
    //page
    pageTitle:{
        color:blueGrey["800"],
        marginBottom:theme.spacing(2),
        textTransform:"uppercase"
    },
}))

export default function Home() {
    const classes = useStyle();
    return (<Box>
            {/*section title*/}
            {/*section card*/}
            {/*section graph*/}
            {/*section posts*/}

            <Grid>
                <Grid item xs={12} sm={12}>
                    <Typography variant='h5' className={classes.pageTitle}>Home</Typography>
                </Grid>
            </Grid>
        </Box>);
}
