import React, {useState} from 'react';
import LoginForm from "../components/LoginForm";
import {Button, Grid, Header, Segment} from "semantic-ui-react";
import axios from 'axios';
import FillerContent from "../components/FillerContent";

function Home() {

    const [user, setUser] = useState({username: "", role: ""})
    const [error, setError] = useState("")
    const [success, setSuccess] = useState(false);
    

    const Login = details => {
       axios.post('http://localhost:8080/profile/authenticate',{username: details.username, password: details.password,  role: details.role})
        .then(res => {
            if(res.data){
                setSuccess(true)
                console.log(res.data)
                setUser({
                    username: details.username,
                    role: details.role
                })
            } else{
                setSuccess(false)
                console.log(res.data)
                setError("LogIn Details Are Not Correct")
                console.log(details.role)
            }
        }).catch(function(e)  {
            setError("LogIn Details Are Not Correct")
            console.log(details.role)

        })
    }
    const Logout = () => {
        setUser({username: "", role: ""});
        setSuccess(false)
    }

    return (
            <Grid columns={2}>
                <Grid.Row></Grid.Row>
                <Grid.Column width={1}/>
                <Grid.Column width={10}>
                    <FillerContent/>
                </Grid.Column>
                <Grid.Column width={4}>
                    {(success) ? (
                        <><Segment raised>
                            <Header>Welcome {user.username}!</Header>
                            <Header></Header>
                            <Button onClick={Logout}>Logout</Button>
                        </Segment>
                        </>
                    ): (
                        <Segment raised>
                            <LoginForm Login={Login} error={error}/>
                        </Segment>
                    )}
                </Grid.Column>
                <Grid.Column width={1}/>
            </Grid>
    );
}

export default Home;