import React from 'react'
import {Route, Routes} from "react-router-dom";
import BranchDirectory from "../components/BranchDirectory";
import BranchDetails from "../components/BranchDetails";
import {Segment} from "semantic-ui-react";

function Branch() {
    return (
        <Segment basic padded='very'>
            <Routes>
                <Route path='/' element={<BranchDirectory/>}/>
                <Route path='/:id' element={<BranchDetails/>}/>
            </Routes>
        </Segment>
    );
}

export default Branch;