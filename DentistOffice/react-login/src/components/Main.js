import React from 'react';
import {Route, Routes} from 'react-router-dom';

import Home from "../pages/Home"
import Receptionist from "../pages/Receptionist"
import Dentist from "../pages/Dentist"
import Patient from "../pages/Patient"
import Branch  from "../pages/Branch"

const Main = () => {
    return (
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/receptionist' element={<Receptionist/>}/>
            <Route path='/dentist' element={<Dentist/>}/>
            <Route path='/patient' element={<Patient/>}/>
            <Route path='/branch/*' element={<Branch/>}/>
        </Routes>
    );
}

export default Main;