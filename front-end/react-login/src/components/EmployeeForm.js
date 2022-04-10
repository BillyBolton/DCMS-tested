import React, {useState} from 'react';
import {Button, Form, Header, Input, Message} from "semantic-ui-react";

function EmployeeForm({AddEmployee, er}){
    const[details, setDetails] = useState({firstName: "", middleName: "", lastName: "", dob: "", email: "", username: "", password: "", street: "", buildingNumber: "", province: "", city:"", postalCode: "", role: "", type: "", salary: "", branch: "", ssn: ""});
  
    const submitHandler = e => {
        e.preventDefault();
        AddEmployee(details);
        
    }

    return (
        <><Form onSubmit={submitHandler}>
        <Header>Add An Employee</Header>
        {(er != "") ? (<div className="error">{er}</div>) : ""}
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
          <Form.Field
            id='ssn'
            control={Input}
            label="SSN"
            placeholder="12345"
            onChange={e => setDetails({ ...details, ssn: e.target.value })} value={details.ssn} />
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
        <Form.Group widths='equal'>
          <Form.Field
            id='role'
            control={Input}
            label='Role'
            placeholder='MANAGER'
            onChange={e => setDetails({ ...details, role: e.target.value })} value={details.role} />
          <Form.Field
            id='type'
            control={Input}
            label='Type'
            placeholder='FT/PT'
            onChange={e => setDetails({ ...details, type: e.target.value })} value={details.type} />
          <Form.Field
            id='salary'
            control={Input}
            label='Salary'
            placeholder='50000'
            onChange={e => setDetails({ ...details, salary: e.target.value })} value={details.salary} />
          <Form.Field
            id='branch'
            control={Input}
            label='Branch'
            placeholder='B_X'
            onChange={e => setDetails({ ...details, branch: e.target.value })} value={details.branch} />
        </Form.Group>
        <Button type='submit'>Add</Button>
      </Form><br></br><div>
          <Message>
            <Message.Header>ROLES AVAILABLE</Message.Header>
            <Message.List>
              <Message.Item>DENTIST</Message.Item>
              <Message.Item>MANAGER</Message.Item>
              <Message.Item>HYGENIST</Message.Item>
              <Message.Item>RECEPTIONIST</Message.Item>
            </Message.List>
            <br></br>

            <Message.Header>TYPES AVAILABLE</Message.Header>
            <Message.List>
              <Message.Item>FT</Message.Item>
              <Message.Item>PT</Message.Item>
            </Message.List>
          </Message>
        </div></>

    )    

}

export default EmployeeForm;