import React, {useState} from 'react';
import {Button, Form, Header, Message} from "semantic-ui-react";

function LoginForm({Login, error}){
    const[details, setDetails] = useState({username: "", password: "", role: ""});
    const submitHandler = e => {
        e.preventDefault();
        Login(details);
        
    }

    return (
        <>
        <Form onSubmit={submitHandler}>
            <Header>Login</Header>
            {(error != "") ? (<div className="error">{error}</div>) : ""}
            <Form.Field>
                <label>Username</label>
                <input
                    type="text"
                    name="username"
                    id="username"
                    onChange={e => setDetails({ ...details, username: e.target.value })} value={details.username}>
                </input>
            </Form.Field>
            <Form.Field>
                <label>Role</label>
                <input
                    type="text"
                    name="role"
                    id="role"
                    onChange={e => setDetails({...details, role: e.target.value})} value={details.role}>
                </input>
            </Form.Field>

            <Form.Field>
                <label>Password</label>
                <input
                    type="password"
                    name="password"
                    id="password"
                    onChange={e => setDetails({ ...details, password: e.target.value })} value={details.password}>
                </input>
            </Form.Field>
            <Button type='submit'>Login</Button>
        </Form>
        <br></br>
        <div>
            <Message>
    <Message.Header>Roles Allowed</Message.Header>
    <Message.List>
      <Message.Item>EMPLOYEE</Message.Item>
      <Message.Item>PATIENT</Message.Item>
      <Message.Item>RESPONSIBLE_PARTY</Message.Item>
    </Message.List>
  </Message>
        </div></>

    )    

}

export default LoginForm;