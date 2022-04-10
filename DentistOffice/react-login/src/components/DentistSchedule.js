import React, { useEffect, useState } from "react";
import {Table, Form, Button, Segment, Header} from 'semantic-ui-react'
import axios from "axios";

const DentistSchedule = () => {

    const [appt, setappt] = useState([]);
    const [details, setDetails] = useState({empId:""})
    const getSchedule = ()=> {
        var id = details.empId
        
        axios.get('http://localhost:8080/appointment/findByEmployeeId?id='+id).then(res => {
            setappt(res.data)
            console.log(res.data)
        }).catch(function (e){
            console.log(e)
        });
    }

    useEffect(() => {
        getSchedule();
    }, []);

    const datify = (dateString) => {
        const dateFormat = new Date(dateString)
        const prettyString = dateFormat.getDate()+'-'+dateFormat.getMonth()+'-'+dateFormat.getFullYear();
        return (prettyString)
    }


    return (
        <>
        <Segment raised compact padded='very'>
        <Form onSubmit={getSchedule}>
        <Form.Field>
        <Header as='h3'>Please enter your ID</Header>
            <input
                type="text"
                name="empId"
                id="empId"
                placeholder='P_X'
                onChange={e => setDetails({...details, empId: e.target.value.trim()})} value={details.empId}>
            </input>
        </Form.Field>
        <Button type='submit'>Search</Button>
        </Form>

        </Segment>
        

        

        <><><h3>Appointment Schedule</h3>
            <Table>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Date</Table.HeaderCell>
                        <Table.HeaderCell>Room</Table.HeaderCell>
                        <Table.HeaderCell>Branch</Table.HeaderCell>
                        <Table.HeaderCell>Doctor</Table.HeaderCell>
                        <Table.HeaderCell>Patient</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {appt.map((ap) => (
                        <Table.Row>
                            <Table.Cell>{datify(ap.startTime)}</Table.Cell>
                            <Table.Cell>{ap.room}</Table.Cell>
                            <Table.Cell>{ap.branchId}</Table.Cell>
                            <Table.Cell>{ap.employeeId}</Table.Cell>
                            <Table.Cell>{ap.patientId}</Table.Cell>
                        </Table.Row>

                    ))}
                </Table.Body>
            </Table>
        </></></>
            
    );

}

      
export default DentistSchedule;