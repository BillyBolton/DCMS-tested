import React, {useState} from 'react';
import {Button, Form, Header, Input, Message} from "semantic-ui-react";

function PatientForm({AddPatient, err}){
    const[details, setDetails] = useState({firstName: "", middleName: "", lastName: "", dob: "", email: "", username: "", password: "", street: "", buildingNumber: "", province: "", city:"", postalCode: ""});
    const options = [
        {key: 1, text: "AB", value: "AB"},
        {key: 2, text: "BC", value: "BC"},
        {key: 3, text: "MB", value: "MB"},
        {key: 4, text: "NB", value: "NB"},
        {key: 5, text: "NS", value: "NS"},
        {key: 6, text: "NL", value: "NL"}, //WHAT IS THIS
        {key: 7, text: "NT", value: "NT"},
        {key: 8, text: "ON", value: "ON"},
        {key: 9, text: "PE", value: "PE"},
        {key: 10, text: "QC", value: "QC"},
        {key: 11, text: "SK", value: "SK"},
        {key: 12, text: "YT", value: "YT"},
        {key: 13, text: "NU", value: "NU"},

    ]
    const submitHandler = e => {
        e.preventDefault();
        AddPatient(details);
        
    }

    return (
        <><Form onSubmit={submitHandler}>
        <Header>Add A Patient</Header>
        {(err != "") ? (<div className="error">{err}</div>) : ""}
        <Form.Group widths='equal'>
          <Form.Field
            id='firstName'
            control={Input}
            label="First Name"
            placeholder="First Name"
            onChange={e => setDetails({ ...details, firstName: e.target.value })} value={details.firstName} />
          <Form.Field
            id='middleName'
            control={Input}
            label="Middle Name"
            placeholder="Middle Name"
            onChange={e => setDetails({ ...details, middleName: e.target.value })} value={details.middleName} />
          <Form.Field
            id='lastName'
            control={Input}
            label="Last Name"
            placeholder="Last Name"
            onChange={e => setDetails({ ...details, lastName: e.target.value })} value={details.lastName} />
          <Form.Field
            id='dob'
            control={Input}
            label="Date Of Birth"
            placeholder="YYYY-MM-DD"
            onChange={e => setDetails({ ...details, dob: e.target.value })} value={details.dob} />
        </Form.Group>
        <Form.Group widths='equal'>
          <Form.Field
            id='email'
            control={Input}
            label='Email'
            placeholder='joe@schmoe.com'
            onChange={e => setDetails({ ...details, email: e.target.value })} value={details.email} />
          <Form.Field
            id='username'
            control={Input}
            label='Username'
            placeholder='username'
            onChange={e => setDetails({ ...details, username: e.target.value })} value={details.username} />
          <Form.Field
            id='password'
            control={Input}
            label='Password'
            placeholder='password'
            onChange={e => setDetails({ ...details, password: e.target.value })} value={details.password} />
        </Form.Group>
        <Form.Group widths='equal'>
          <Form.Field
            id='street'
            control={Input}
            label='Street Name'
            placeholder='Street'
            onChange={e => setDetails({ ...details, street: e.target.value })} value={details.street} />
          <Form.Field
            id='buildingNumber'
            control={Input}
            label='Building Number'
            placeholder='1234'
            onChange={e => setDetails({ ...details, buildingNumber: e.target.value })} value={details.buildingNumber} />
        </Form.Group>
        <Form.Group widths='equal'>
          <Form.Field
            id='city'
            control={Input}
            label='City'
            placeholder='city'
            onChange={e => setDetails({ ...details, city: e.target.value })} value={details.city} />
          <Form.Field
            id='province'
            control={Input}
            label='Province'
            placeholder='ON'
            onChange={e => setDetails({ ...details, province: e.target.value })} value={details.province} />
          <Form.Field
            id='postalCode'
            control={Input}
            label='Postal Code'
            placeholder='LNL NLN'
            onChange={e => setDetails({ ...details, postalCode: e.target.value })} value={details.postalCode} />
        </Form.Group>
        <Button type='submit'>Add</Button>
      </Form><br></br><div>
          <Message>
            <Message.Header>PROVINCES LEGEND</Message.Header>
            <Message.List>
              <Message.Item>AB,BC,MB,NB,NS,NL,NT,ON,PE,QC,SK,YT,NU</Message.Item>
            </Message.List>
          </Message>
        </div></>

    )    

}

export default PatientForm;