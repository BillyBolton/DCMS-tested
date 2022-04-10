import React, { useEffect, useState } from "react";
import {Table} from 'semantic-ui-react'
import axios from "axios";

const PatientSchedule = (props) => {

    const [appt, setappt] = useState([]);

    const getSchedule = ()=> {
        
        axios.get('http://localhost:8080/appointment/findByPatientId?id='+props.profile.id).then(res => {
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
        { appt.length > 0 ?
            <Table>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Date</Table.HeaderCell>
                        <Table.HeaderCell>Room</Table.HeaderCell>
                        <Table.HeaderCell>Branch</Table.HeaderCell>
                        <Table.HeaderCell>Doctor</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {appt.map((ap) => (
                        <Table.Row>
                            <Table.Cell>{datify(ap.startTime)}</Table.Cell>
                            <Table.Cell>{ap.room}</Table.Cell>
                            <Table.Cell>{ap.branchId}</Table.Cell>
                            <Table.Cell>{ap.employeeId}</Table.Cell>
                        </Table.Row>

                    ))}
                </Table.Body>
            </Table>
        
        :

        <p>Patient has no upcoming appointments.</p>

        }
            
        </>
            
    );

}

      
export default PatientSchedule;