import axios from 'axios';
import React, {useState} from 'react';
import AppointmentForm from '../components/AppointmentForm';
import {Segment} from "semantic-ui-react";
import Schedule from '../components/Schedule';
import PatientForm from '../components/PatientForm';
import EmployeeForm from '../components/EmployeeForm';

function Receptionist() {

    //PATIENT
    const [err, setErr] = useState("")
    const [successP, setSuccessP] = useState(false);

    const AddPatient  = details => {
        let res = axios.post('http://localhost:8080/patient/create', {email: details.email, id: "", profile: {id: "", username: details.username, password: details.password, firstName: details.firstName, middleName: details.middleName, lastName: details.lastName, address: {id: "", buildingNumber: parseInt(details.buildingNumber), street: details.street, city: details.city, province: details.province, postalCode: details.postalCode}, dob: details.dob}})
        .then(res => {
            console.log(res)
            if(res.status == 200){
                setSuccessP(true)
                console.log(res.status)
            } else{
                setSuccessP(false)
                console.log(res.status)
                setErr("DID NOT WORK")
            }
        }).catch(function(e) {
            console.log(e)
        })


    }

    const [er, setEr] = useState("")
    const [successE, setSuccessE] = useState(false);

    //EMPLOYEE
    const AddEmployee  = details => {
        let res = axios.post('http://localhost:8080/employee/create/lite', {role: details.role, type: details.type, salary: parseInt(details.salary), id: "", branchID: details.branch, profile: {id: "", username: details.username, password: details.password, firstName: details.firstName, middleName: details.middleName, lastName: details.lastName, address: {id: "", buildingNumber: parseInt(details.buildingNumber), street: details.street, city: details.city, province: details.province, postalCode: details.postalCode}, dob: details.dob}, ssn: parseInt(details.ssn)})
        .then(res => {
            console.log(res)
            if(res.status == 200){
                setSuccessE(true)
                console.log(res.status)
            } else{
                setSuccessE(false)
                console.log(res.status)
                setEr("DID NOT WORK")
            }
        }).catch(function(e) {
            console.log(e)
            console.log(res.status)
            
        })


    }

    //APPOINTMENT
    const [error, setError] = useState("")
    const [successA, setSuccessA] = useState(false);

    const AddApp = details =>{
        axios.post("http://localhost:8080/appointment/create", {id: 4, startTime: details.date+"T"+details.startTime, endTime: details.date+"T"+details.endTime, type: parseInt(details.type), status: parseInt(details.status), room: details.room, branchId: details.branchId, employeeId: details.employeeId, patientId: details.patientId})
        .then(res => {
            console.log(res)
            if(res.status == 200){
                setSuccessA(true)
                console.log(res.status)
                console.log(parseInt(details.type))
            } else{
                setSuccessA(false)
                console.log(res.status)
                setError("DID NOT WORK")
            }
        }).catch(function(e) {
            console.log("ERROR")
            console.log(e)
        })


    }
    
    return (
        <div className="Receptionist">
            {(successP) ? (
                <div className="Stay">
                    <PatientForm/>
                </div>
            ): (
                <Segment raised>
                    <PatientForm AddPatient={AddPatient} err={err}/>
                </Segment>
            )} 
             
            <br></br>
            
            {(successE) ? (
                <div className="Stay">
                    <EmployeeForm/>
                </div>
            ): (
                <Segment raised>
                    <EmployeeForm AddEmployee={AddEmployee} er={er}/>
                </Segment>
            )}
            <br></br>
            {(successA) ? (
                <div className="Stay">
                    <AppointmentForm/>
                </div>
            ): (
                <Segment raised>
                    <AppointmentForm AddApp={AddApp} error={error}/>
                </Segment>
            )}
            <br></br>
            <div><Segment raised>
            <Schedule/>
                </Segment></div>        
        </div>
        
    );
}


export default Receptionist;
