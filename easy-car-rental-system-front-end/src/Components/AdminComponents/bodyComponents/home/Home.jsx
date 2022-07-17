import React from 'react'
import {Box, Button, Card, CardContent, Grid, Typography} from "@material-ui/core";
import {PageHeader} from "../../../../common/CommonComponent";
import {useStyle} from "../BodyStyle";
import ArrowDropDownIcon from '@mui/icons-material/ArrowDropDown';

export default function Home() {
    const classes = useStyle();
    return (<Box>
        {/*section title*/}
        {/*section card*/}
        {/*section graph*/}
        {/*section posts*/}
        <PageHeader label="Home" pageTitle="Overview"/>

        <Grid container>
            <Grid item xs={6} sm={3}>
                <Card>
                    <CardContent>
                        <Typography variant="body2" className={classes.cardLable}>Vehicles</Typography>
                        <Typography variant="h5" component="h6" className={classes.cardTitle}>50</Typography>
                        <Typography component="p" style={{textAlign: "center", marginBottom: "0px"}}>
                            <Button size="small" className={classes.ratioBtn}
                                    startIcon={<ArrowDropDownIcon/>}>5%</Button>
                        </Typography>
                    </CardContent>
                </Card>
            </Grid>
        </Grid>

    </Box>);
}
