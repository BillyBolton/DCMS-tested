import React, {useState} from 'react';
import {Button, Form, Header, Input, Message} from "semantic-ui-react";

function AppointmentForm({AddApp, error}){
    const[details, setDetails] = useState({date: "",startTime: "", endTime: "", patientId: "", employeeId: "", type: "", status: "", room: "", branchId: ""});
    const submitHandler = e => {
        e.preventDefault();
        AddApp(details);
        
    }

    return (
        <><Form onSubmit={submitHandler}>
        <Header>Schedule An Appointment</Header>
        {(error != "") ? (<div className="error">{error}</div>) : ""}
        <Form.Group widths='equal'>
          <Form.Field
            id='date'
            control={Input}
            label="Date"
            placeholder='YYYY-MM-DD'
            onChange={e => setDetails({ ...details, date: e.target.value })} value={details.date} />
          <Form.Field
            id='startTime'
            control={Input}
            label="Start Time"
            placeholder='HH:MM:SS'
            onChange={e => setDetails({ ...details, startTime: e.target.value })} value={details.startTime} />
          <Form.Field
            id='endTime'
            control={Input}
            label="End Time"
            placeholder='HH:MM:SS'
            onChange={e => setDetails({ ...details, endTime: e.target.value })} value={details.endTime} />
        </Form.Group>
        <Form.Group widths='equal'>
          <Form.Field
            id='patientId'
            control={Input}
            label='Patient'
            placeholder='P_x'
            onChange={e => setDetails({ ...details, patientId: e.target.value })} value={details.patientId} />
          <Form.Field
            id='employeeId'
            control={Input}
            label='Employee'
            placeholder='E_x'
            onChange={e => setDetails({ ...details, employeeId: e.target.value })} value={details.employeeId} />
        </Form.Group>
        <Form.Group widths='equal'>
          <Form.Field
            id='type'
            control={Input}
            label='Type'
            placeholder='Appointment Type'
            onChange={e => setDetails({ ...details, type: e.target.value })} value={details.type} />
          <Form.Field
            id='status'
            control={Input}
            label='Status'
            placeholder='Appointment Status'
            onChange={e => setDetails({ ...details, status: e.target.value })} value={details.status} />
          <Form.Field
            id='room'
            control={Input}
            label='Room'
            placeholder='RX'
            onChange={e => setDetails({ ...details, room: e.target.value })} value={details.room} />
          <Form.Field
            id='branchId'
            control={Input}
            label='Branch'
            placeholder='B_1'
            onChange={e => setDetails({ ...details, branchId: e.target.value })} value={details.branchId} />
        </Form.Group>
        <Button type='submit'>Add</Button>
      </Form><br></br><div>
          <Message>
            <Message.Header>APPOINTMENT STATUS LEGEND</Message.Header>
            <Message.List>
              <Message.Item>NO SHOW: 1</Message.Item>
              <Message.Item>CANCELLED: 2</Message.Item>
              <Message.Item>COMPLETED: 3</Message.Item>
              <Message.Item>UNSCHEDULED: 4</Message.Item>
              <Message.Item>SCHEDULED: 5</Message.Item>
            </Message.List>
            <br></br>

            <Message.Header>APPOINTMENT TYPES AVAILABLE</Message.Header>
            <Message.List>
              <Message.Item>CLEANING: 1</Message.Item>
              <Message.Item>FILLING: 2</Message.Item>
              <Message.Item>EXTRACTION: 3</Message.Item>
            </Message.List>
          </Message>
        </div></>

    )    

}

export default AppointmentForm;